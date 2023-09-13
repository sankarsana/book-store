package feature.store.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import feature.store.data.StoreRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class StoreViewModel : ViewModel() {

    private val _state = MutableStateFlow<StoreUiState>(StoreUiState.Loading)
    val state: StateFlow<StoreUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            delay(1000)
            _state.value = StoreUiState.Books(StoreRepository.getBooks())
        }
    }
}
