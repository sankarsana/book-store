package common.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
internal interface BooksDao {

    @Query("select * from books")
    suspend fun getAllBooks(): List<BookLocal>

    @Query("select * from writers")
    suspend fun getAllWriters(): List<WriterLocal>

    @Insert
    suspend fun addBooks(books: List<BookLocal>)

    @Insert
    suspend fun addWriters(writers: List<WriterLocal>)
}
