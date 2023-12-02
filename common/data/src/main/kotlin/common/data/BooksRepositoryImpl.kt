package common.data

import common.data.local.LocalDataSource
import common.data.remote.BookStoreNetworkDataSource

internal class BooksRepositoryImpl(
    private val remoteDataSource: BookStoreNetworkDataSource,
    private val localDataSource: LocalDataSource,
) : BooksRepository {

    override suspend fun getAllBooks(): List<Book> {
        val remote = remoteDataSource.getAll()
        return remote.books.map {
            Book(
                name = it.name,
                shortName = it.shortName,
                price = it.price.toString(),
            )
        }
    }
}
