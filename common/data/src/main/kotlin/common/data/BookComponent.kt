package common.data

import android.content.Context
import common.data.book.BookRepository
import common.data.book.BookRepositoryImpl

interface BookComponent {
    val bookRepository: BookRepository
}

internal class BookComponentImpl : BookComponent {

    override val bookRepository: BookRepository
        get() = BookRepositoryImpl()

}

object BookComponentHolder {

    private var component: BookComponent? = null

    fun get(): BookComponent {
        return requireNotNull(component)
    }

    fun set(context: Context) {
        component = BookComponentImpl()
    }
}
