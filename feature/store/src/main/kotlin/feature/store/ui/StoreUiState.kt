package feature.store.ui

internal sealed class StoreUiState {

    object Loading : StoreUiState()

    class Books(
        val books: List<BookUiItem>,
    ) : StoreUiState()
}
