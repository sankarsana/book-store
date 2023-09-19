package nrs.sankarsana.book.store

import android.app.Application
import common.data.BookComponentHolder

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        BookComponentHolder.set(this)
    }
}
