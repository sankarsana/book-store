package feature.store.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import feature.store.ui.views.AppBar

@Composable
fun StoreScreen() {
    val viewModel: StoreViewModel = viewModel(factory = provideStoreViewModelFactory())
    val state = viewModel.state.collectAsState()
    when (val stateValue = state.value) {
        is StoreUiState.Loading -> showLoading()
        is StoreUiState.Content -> ShowContent(stateValue, viewModel)
    }
}

private fun showLoading() {

}

@Composable
private fun ShowContent(state: StoreUiState.Content, viewModel: StoreViewModel) {
    Scaffold(
        modifier = Modifier,
        topBar = AppBar(
            state = state.appBarState,
            onSearchIconClick = viewModel::onSearchIconClick,
            onClearClick = viewModel::onClearClick,
        ),
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
