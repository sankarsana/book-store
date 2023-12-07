package common.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import common.data.local.BooksVersionProvider
import common.data.remote.BookStoreApi
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import timber.log.Timber

internal class NetworkModule(
    private val booksVersionProvider: BooksVersionProvider,
) {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    fun provideBookStoreApi(): BookStoreApi {
        return getRetrofit().create(BookStoreApi::class.java)
    }

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(getHttpClient())
        .addConverterFactory(json.asConverterFactory(JSON_MIME_TYPE.toMediaType()))
        .build()

    private fun getHttpClient() = OkHttpClient.Builder()
        .addInterceptor(getDatabaseVersionHeaderInterceptor())
        .addInterceptor(loggingInterceptor())
        .build()

    private fun getDatabaseVersionHeaderInterceptor() = Interceptor { chain ->
        val databaseVersion = runBlocking {
            booksVersionProvider.getBooksVersion().toString()
        }
        val request = chain.request().newBuilder()
            .header(DATABASE_VERSION_HEADER, databaseVersion)
            .build()
        chain.proceed(request)
    }

    private fun loggingInterceptor(): Interceptor {
        val logger = HttpLoggingInterceptor.Logger { message ->
            Timber.i(message)
        }
        return HttpLoggingInterceptor(logger).apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    private companion object {
        const val BASE_URL = "http://10.0.2.2:8080"
        const val DATABASE_VERSION_HEADER = "database_version"
        const val JSON_MIME_TYPE = "application/json"
    }
}
