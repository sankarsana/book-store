package feature.store.ui

internal sealed interface StoreState {

    data object Loading : StoreState

    data object Empty : StoreState

    data class Content(
        val searchState: SearchState,
        val books: List<BookState>,
    ) : StoreState
}
