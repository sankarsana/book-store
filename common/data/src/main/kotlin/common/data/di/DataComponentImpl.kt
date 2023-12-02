package common.data.di

import android.content.Context
import common.data.BooksRepository
import common.data.BooksRepositoryImpl
import common.data.StoreVersionProvider
import common.data.local.LocalDataSource
import common.data.remote.BookStoreApi
import common.data.remote.BookStoreNetworkDataSource
import common.data.remote.BooksDatabase

internal class DataComponentImpl(context: Context) : DataComponent {

    private val appPrefs = context.getSharedPreferences("app", Context.MODE_PRIVATE)
    private val storeVersionProvider = StoreVersionProvider(appPrefs)

    private val bookStoreApi: BookStoreApi = NetworkModule.provideBookStoreApi(storeVersionProvider)
    private val dataBase: BooksDatabase = DatabaseModule.provideBooksDatabase(context)

    override fun bookRepository(): BooksRepository = BooksRepositoryImpl(
        remoteDataSource = provideBookStoreNetDataSource(),
        localDataSource = provideLocalDataSource(),
    )

    private fun provideBookStoreNetDataSource() = BookStoreNetworkDataSource(
        api = bookStoreApi,
    )

    private fun provideLocalDataSource() = LocalDataSource(
        dao = dataBase.booksDao()
    )
}
