package feature.store.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview
@Composable
fun StoreScreen() {
    val viewModel: StoreViewModel = viewModel()
    val state = viewModel.state.collectAsState()
    when (val stateValue = state.value) {
        is StoreUiState.Loading -> renderLoading()
        is StoreUiState.Books -> renderBooks(stateValue.books)
    }

}

fun renderLoading() {

}

@Composable
fun renderBooks(books: List<BookUiItem>) {
    LazyColumn {
        items(items = books) {
            BookItem(it)
        }
    }
}
