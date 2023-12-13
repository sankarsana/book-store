package feature.store.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import feature.store.ui.BookItem
import feature.store.ui.StoreAction
import feature.store.ui.StoreState

@Composable
internal fun Store(state: StoreState.Content, onAction: (StoreAction) -> Unit) {
    Column(
        modifier = Modifier.padding(top = 8.dp)
    ) {
        SearchBar(
            state = state.searchBarState,
            onAction = onAction,
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {
            items(items = state.books) {
                BookItem(it)
            }
        }
    }
}
