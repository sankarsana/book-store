package common.core.book

interface BookRepository {

    suspend fun getAll(): List<Book>
}
