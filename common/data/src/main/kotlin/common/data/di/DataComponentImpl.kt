package common.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import common.data.BooksRepository
import common.data.BooksRepositoryImpl
import common.data.local.BooksDatabase
import common.data.local.LocalDataSource
import common.data.local.StoreVersionProvider
import common.data.remote.BookStoreApi
import common.data.remote.BookStoreNetworkDataSource

internal class DataComponentImpl(context: Context) : DataComponent {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    private val storeVersionProvider = StoreVersionProvider(context.dataStore)
    private val bookStoreApi: BookStoreApi =
        NetworkModule(storeVersionProvider).provideBookStoreApi()
    private val dataBase: BooksDatabase = DatabaseModule.provideBooksDatabase(context)

    override fun bookRepository(): BooksRepository = BooksRepositoryImpl(
        remoteDataSource = provideBookStoreNetDataSource(),
        localDataSource = provideLocalDataSource(),
        storeVersionProvider = storeVersionProvider,
    )

    private fun provideBookStoreNetDataSource() = BookStoreNetworkDataSource(
        api = bookStoreApi,
    )

    private fun provideLocalDataSource() = LocalDataSource(
        dao = dataBase.booksDao()
    )
}
