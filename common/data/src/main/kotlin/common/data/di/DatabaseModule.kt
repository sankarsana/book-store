package common.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import common.data.local.BooksDatabase
import timber.log.Timber
import java.util.concurrent.Executors

internal object DatabaseModule {

    fun provideBooksDatabase(context: Context): BooksDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = BooksDatabase::class.java,
            name = DATABASE_NAME,
        )
            .setQueryCallback(loggingCallback(), Executors.newSingleThreadExecutor())
            .build()
    }

    private fun loggingCallback() = RoomDatabase.QueryCallback { query, args ->
        val args = if (args.isNotEmpty()) ", args: $args" else ""
        Timber.i("$query$args")
    }

    private const val DATABASE_NAME = "books-database"
}
