package feature.store.di

import common.data.BooksRepository
import common.data.di.DataComponentHolder

internal interface StoreDependencies {

    val bookRepository: BooksRepository
        get() = DataComponentHolder.get().bookRepository()

    object Impl : StoreDependencies
}
