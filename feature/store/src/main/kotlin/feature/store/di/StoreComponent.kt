package feature.store.di

import feature.store.ui.StoreViewModel

internal interface StoreComponent {

    fun getStoreViewModel(): StoreViewModel

    companion object {
        fun create(): StoreComponent {
            return StoreComponentImpl(
                dependencies = StoreDependencies.Impl,
                module = StoreModule.Impl(),
            )
        }
    }
}

private class StoreComponentImpl(
    dependencies: StoreDependencies,
    module: StoreModule,
) : StoreComponent, StoreDependencies by dependencies, StoreModule by module {

    override fun getStoreViewModel(): StoreViewModel {
        return provideStoreViewModel()
    }
}
