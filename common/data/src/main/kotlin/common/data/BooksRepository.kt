package common.data

interface BooksRepository {

    suspend fun getAllBooks(): List<Book>
}
