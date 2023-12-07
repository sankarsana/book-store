package feature.store.ui

internal sealed class StoreUiState {

    data object Loading : StoreUiState()

    data class Content(
        val appBarState: AppBarState,
        val books: List<BookItemState>,
    ) : StoreUiState()
}
