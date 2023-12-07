package feature.store.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.data.BooksRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class StoreViewModel(
    private val repository: BooksRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<StoreUiState>(StoreUiState.Loading)
    val state: StateFlow<StoreUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val books = repository.getAllBooks(updateFromRemote = true).map(BooksMapper::toUi)
            _state.value = StoreUiState.Content(AppBarState.Main, books)
        }
    }

    fun onSearchIconClick() {
        updateContent {
            copy(
                appBarState = AppBarState.Search
            )
        }
    }

    fun onClearClick() {
        updateContent {
            copy(
                appBarState = AppBarState.Main
            )
        }
    }

    private fun updateContent(block: StoreUiState.Content.() -> StoreUiState.Content) {
        _state.value = block(_state.value as StoreUiState.Content)
    }
}
