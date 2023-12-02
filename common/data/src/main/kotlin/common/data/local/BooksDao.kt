package common.data.local

import androidx.room.Dao
import androidx.room.Query

@Dao
internal interface BooksDao {

    @Query("select * from books")
    fun getAllBooks(): List<BookLocal>

    @Query("select * from writers")
    fun getAllWriters(): List<WriterLocal>
}
