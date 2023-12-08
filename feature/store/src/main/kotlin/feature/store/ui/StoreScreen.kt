package feature.store.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import feature.store.ui.views.Content
import feature.store.ui.views.Loading

@Composable
fun StoreScreen() {
    val viewModel: StoreViewModel = viewModel(factory = provideStoreViewModelFactory())
    val state = viewModel.state.collectAsState()
    when (val stateValue = state.value) {
        is StoreUiState.Loading -> Loading()
        is StoreUiState.Content -> Content(stateValue, viewModel)
    }
}
