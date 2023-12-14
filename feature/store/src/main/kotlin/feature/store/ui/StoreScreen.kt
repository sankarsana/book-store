package feature.store.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import feature.store.di.StoreComponent
import feature.store.ui.views.Loading
import feature.store.ui.views.Store

@Composable
fun StoreScreen() {
    val viewModel: StoreViewModel = viewModelWithSavedState {
        StoreComponent.create().getStoreViewModel()
    }
    val state = viewModel.state.collectAsState()
    when (val stateValue = state.value) {
        is StoreState.Loading -> Loading()
        is StoreState.Content -> Store(stateValue, viewModel::obtainEvent)
    }
}
