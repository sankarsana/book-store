package feature.store.ui

internal sealed class StoreState {

    data object Loading : StoreState()

    data class Content(
        val searchBarState: SearchBarState,
        val books: List<BookItemState>,
    ) : StoreState()
}
