package common.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import common.data.StoreVersionProvider
import common.data.remote.BookStoreApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

internal object NetworkModule {

    fun provideBookStoreApi(storeVersionProvider: StoreVersionProvider): BookStoreApi {
        return getRetrofit(storeVersionProvider).create(BookStoreApi::class.java)
    }

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    private fun getRetrofit(storeVersionProvider: StoreVersionProvider) = Retrofit.Builder()
        .baseUrl(BookStoreApi.BASE_URL)
        .client(getHttpClient(storeVersionProvider))
        .addConverterFactory(provideConvertorFactory())
        .build()

    private fun getHttpClient(storeVersionProvider: StoreVersionProvider) = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .header("database_version", storeVersionProvider.get().toString()).build()
            chain.proceed(request)
        }
        .build()

    private fun provideConvertorFactory(): Converter.Factory {
        val contentType = "application/json".toMediaType()
        return json.asConverterFactory(contentType)
    }
}
