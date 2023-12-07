package common.data

import common.data.local.LocalDataSource
import common.data.local.StoreVersionProvider
import common.data.remote.BookStoreNetworkDataSource

internal class BooksRepositoryImpl(
    private val remoteDataSource: BookStoreNetworkDataSource,
    private val localDataSource: LocalDataSource,
    private val storeVersionProvider: StoreVersionProvider,
) : BooksRepository {

    override suspend fun getAllBooks(updateFromRemote: Boolean): List<Book> {
        if (updateFromRemote) updateFromRemote()
        return localDataSource.getAllBooks().toBooks()
    }

    private suspend fun updateFromRemote() {
        val remote = remoteDataSource.getAll()
        if (remote.databaseVersion > storeVersionProvider.getBooksVersion()) {
            localDataSource.addBooks(remote.books.toBooksLocal())
            localDataSource.addWriters(remote.writers.toWritersLocal())
            storeVersionProvider.setBookVersion(remote.databaseVersion)
        }
    }
}
