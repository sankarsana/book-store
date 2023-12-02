package common.data

interface BooksRepository {

    suspend fun getAll(): List<Book>
}
