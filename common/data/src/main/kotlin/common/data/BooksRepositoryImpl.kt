package common.data

import common.data.local.BooksVersionProvider
import common.data.local.LocalDataSource
import common.data.remote.RemoteDataSource

internal class BooksRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val booksVersionProvider: BooksVersionProvider,
) : BooksRepository {

    override suspend fun getAllBooks(updateFromRemote: Boolean): List<Book> {
        if (updateFromRemote) updateFromRemote()
        return localDataSource.getAllBooks().toBooks()
    }

    private suspend fun updateFromRemote() {
        val remote = try {
            remoteDataSource.getAllBooks()
        } catch (e: Exception) {
            return
        }
        if (remote.databaseVersion > booksVersionProvider.getBooksVersion()) {
            localDataSource.addBooks(remote.books.toBooksLocal())
            localDataSource.addWriters(remote.writers.toWritersLocal())
            booksVersionProvider.setBookVersion(remote.databaseVersion)
        }
    }
}
