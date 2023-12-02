package common.data

import common.data.net.BookStoreNetworkDataSource

internal class BooksRepositoryImpl(
    private val netDataSource: BookStoreNetworkDataSource,
) : BooksRepository {

    override suspend fun getAll(): List<Book> {
        val response = netDataSource.getAll()
        return response.books.map {
            Book(
                name = it.name,
                shortName = it.shortName,
                price = it.price.toString(),
            )
        }
    }
}
