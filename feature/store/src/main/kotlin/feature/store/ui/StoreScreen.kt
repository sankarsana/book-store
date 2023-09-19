package feature.store.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun StoreScreen() {
    val viewModel: StoreViewModel = viewModel(factory = provideStoreViewModelFactory())
    val state = viewModel.state.collectAsState()
    when (val stateValue = state.value) {
        is StoreUiState.Loading -> showLoading()
        is StoreUiState.Books -> showBooks(stateValue.books)
    }

}

private fun showLoading() {

}

@Composable
private fun showBooks(books: List<BookUiItem>) {
    LazyColumn {
        items(items = books) {
            BookItem(it)
        }
    }
}
