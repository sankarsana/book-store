package common.data.di

import android.content.Context
import common.data.BooksRepository

interface DataComponent {
    fun bookRepository(): BooksRepository
}

object DataComponentHolder {

    private var component: DataComponent? = null

    fun get(): DataComponent {
        return requireNotNull(component)
    }

    fun set(context: Context) {
        component = DataComponentImpl(context)
    }
}
