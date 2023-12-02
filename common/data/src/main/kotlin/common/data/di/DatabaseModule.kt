package common.data.di

import android.content.Context
import androidx.room.Room
import common.data.remote.BooksDatabase

internal object DatabaseModule {

    fun provideBooksDatabase(context: Context): BooksDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = BooksDatabase::class.java,
            name = DATABASE_NAME,
        ).build()
    }

    private const val DATABASE_NAME = "books-database"
}
