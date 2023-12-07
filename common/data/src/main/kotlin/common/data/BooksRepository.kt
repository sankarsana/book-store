package common.data

interface BooksRepository {

    suspend fun getAllBooks(updateFromRemote: Boolean = false): List<Book>
}
