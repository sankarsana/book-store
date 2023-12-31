package common.data

import common.data.exception.RemoteServerException
import common.data.local.BooksVersionProvider
import common.data.local.LocalDataSource
import common.data.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class BooksRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val booksVersionProvider: BooksVersionProvider,
) : BooksRepository {

    override fun getAllBooks(): Flow<List<Book>> = flow {
        val local = localDataSource.getAllBooks()
        if (local.isNotEmpty()) emit(local.toBooks())
        if (updateFromRemote()) {
            emit(localDataSource.getAllBooks().toBooks())
        } else if (local.isEmpty()) {
            emit(emptyList())
        }
    }

    private suspend fun updateFromRemote(): Boolean {
        val remote = try {
            remoteDataSource.getAllBooks()
        } catch (e: Exception) {
            throw RemoteServerException(e.message, e.cause)
        }
        val isRemoteVersionGreater = remote.databaseVersion > booksVersionProvider.getBooksVersion()
        if (isRemoteVersionGreater) {
            localDataSource.addBooks(remote.books.toBooksLocal())
            localDataSource.addWriters(remote.writers.toWritersLocal())
            booksVersionProvider.setBookVersion(remote.databaseVersion)
        }
        return isRemoteVersionGreater
    }
}
