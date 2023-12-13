package feature.store.ui

sealed interface StoreAction {

    sealed interface Search : StoreAction {

        data object ClearClicked : Search

        class QueryChanged(val query: String) : Search
    }

}
