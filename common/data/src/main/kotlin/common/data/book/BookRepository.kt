package common.data.book

interface BookRepository {

    suspend fun getAll(): List<Book>
}
