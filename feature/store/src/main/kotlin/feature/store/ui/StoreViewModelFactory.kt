package feature.store.ui

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import common.data.BookComponentHolder

fun provideStoreViewModelFactory() = viewModelFactory {
    initializer {
        StoreViewModel(
            repository = BookComponentHolder.get().bookRepository
        )
    }
}
