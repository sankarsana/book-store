package common.data

import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    fun getAllBooks(): Flow<List<Book>>
}
