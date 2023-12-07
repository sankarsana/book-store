package common.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import common.data.BooksRepository
import common.data.BooksRepositoryImpl
import common.data.local.BooksDatabase
import common.data.local.BooksVersionProvider
import common.data.local.LocalDataSource
import common.data.remote.BookStoreApi
import common.data.remote.RemoteDataSource

internal class DataComponentImpl(context: Context) : DataComponent {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    private val booksVersionProvider = BooksVersionProvider(context.dataStore)
    private val bookStoreApi: BookStoreApi =
        NetworkModule(booksVersionProvider).provideBookStoreApi()
    private val dataBase: BooksDatabase = DatabaseModule.provideBooksDatabase(context)

    override fun bookRepository(): BooksRepository = BooksRepositoryImpl(
        remoteDataSource = provideBookStoreNetDataSource(),
        localDataSource = provideLocalDataSource(),
        booksVersionProvider = booksVersionProvider,
    )

    private fun provideBookStoreNetDataSource() = RemoteDataSource(
        api = bookStoreApi,
    )

    private fun provideLocalDataSource() = LocalDataSource(
        dao = dataBase.booksDao()
    )
}
