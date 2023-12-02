package common.data.remote

import androidx.room.Database
import androidx.room.RoomDatabase
import common.data.local.BookLocal
import common.data.local.BooksDao
import common.data.local.WriterLocal

@Database(
    entities = [
        BookLocal::class,
        WriterLocal::class,
    ],
    version = 1,
)
internal abstract class BooksDatabase : RoomDatabase() {

    abstract fun booksDao(): BooksDao
}
