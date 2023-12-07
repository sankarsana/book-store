package common.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

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
