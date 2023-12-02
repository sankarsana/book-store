package feature.store.ui

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import common.data.di.DataComponentHolder

fun provideStoreViewModelFactory() = viewModelFactory {
    initializer {
        StoreViewModel(
            repository = DataComponentHolder.get().bookRepository()
        )
    }
}
