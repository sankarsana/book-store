package nrs.sankarsana.book.store

import android.app.Application
import common.data.di.DataComponentHolder
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        DataComponentHolder.set(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
