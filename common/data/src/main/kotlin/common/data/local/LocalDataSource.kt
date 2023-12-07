package common.data.local

internal class LocalDataSource(
    private val dao: BooksDao,
) {
    suspend fun getAllBooks(): List<BookLocal> {
        return dao.getAllBooks()
    }

    suspend fun addBooks(books: List<BookLocal>) {
        dao.addBooks(books)
    }

    suspend fun addWriters(writers: List<WriterLocal>) {
        dao.addWriters(writers)
    }
}
