package feature.store.ui.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import feature.store.ui.BookItem
import feature.store.ui.StoreUiState
import feature.store.ui.StoreViewModel

@Composable
internal fun Content(state: StoreUiState.Content, viewModel: StoreViewModel) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            AppBarSearch(
                state = state.appBarState,
                onClearClick = viewModel::onClearClick,
                onQueryChange = viewModel::onSearchQueryChanged,
            )
        },
    ) { values ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(values)
                .padding(top = 8.dp)
        ) {
            items(items = state.books) {
                BookItem(it)
            }
        }
    }
}
