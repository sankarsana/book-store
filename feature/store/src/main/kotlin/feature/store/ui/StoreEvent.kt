package feature.store.ui

sealed interface StoreEvent {

    sealed interface Search : StoreEvent {

        data object ClearClicked : Search

        class QueryChanged(val query: String) : Search
    }
}
