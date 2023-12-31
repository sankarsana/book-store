package feature.store.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import feature.store.ui.BookStatePreviewData
import feature.store.ui.SearchState
import feature.store.ui.StoreEvent
import feature.store.ui.StoreState

@Composable
internal fun Store(state: StoreState.Content, onAction: (StoreEvent) -> Unit) {
    Column(
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Search(
            state = state.searchState,
            onQueryChanged = { onAction(StoreEvent.Search.QueryChanged(it)) },
            onClearClicked = { onAction(StoreEvent.Search.ClearClicked) }
        )
        BookList(
            books = state.books,
            modifier = Modifier.padding(top = 16.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StorePreview() = Store(
    state = StoreState.Content(
        searchState = SearchState(),
        books = listOf(BookStatePreviewData()),
    ),
    onAction = {}
)

