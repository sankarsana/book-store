package feature.store.ui

internal sealed class StoreState {

    data object Loading : StoreState()

    data class Content(
        val searchState: SearchState,
        val books: List<BookState>,
    ) : StoreState()
}
