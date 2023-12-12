package feature.store.di

import feature.store.domain.FilterBooksUseCase
import feature.store.ui.StoreViewModel

internal interface StoreModule {

    fun provideStoreViewModel(): StoreViewModel

    class Impl(
        dependencies: StoreDependencies = StoreDependencies.Impl,
    ) : StoreModule, StoreDependencies by dependencies {

        override fun provideStoreViewModel(): StoreViewModel {
            return StoreViewModel(
                repository = bookRepository,
                filterBooksUseCase = provideFilterBooksUseCase(),
            )
        }

        private fun provideFilterBooksUseCase() = FilterBooksUseCase()
    }
}
