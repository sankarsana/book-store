package common.data.di

import android.content.Context
import common.data.BooksRepository
import common.data.BooksRepositoryImpl
import common.data.StoreVersionProvider
import common.data.net.BookStoreNetworkDataSource

internal class DataComponentImpl(context: Context) : DataComponent {

    private val appPrefs = context.getSharedPreferences("app", Context.MODE_PRIVATE)
    private val storeVersionProvider = StoreVersionProvider(appPrefs)
    private val networkModule: NetworkModule = NetworkModule(storeVersionProvider)

    override fun bookRepository(): BooksRepository = BooksRepositoryImpl(
        netDataSource = provideBookStoreNetDataSource()
    )

    private fun provideBookStoreNetDataSource() = BookStoreNetworkDataSource(
        api = networkModule.provideBookStoreApi(),
    )
}
