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

    private val content: StoreUiState.Content get() = _state.value as StoreUiState.Content

    init {
        viewModelScope.launch {
            val books = repository.getAllBooks(updateFromRemote = true).map(BooksMapper::toUi)
            _state.value = StoreUiState.Content(AppBarState(), books)
        }
    }

    fun onSearchQueryChanged(query: String) {
        updateContent {
            copy(
                appBarState = appBarState.copy(
                    query = query,
                    showClearButton = query.isNotEmpty()
                )
            )
        }
    }

    fun onClearClick() {
        updateContent {
            copy(
                appBarState = content.appBarState.copy(
                    query = "",
                    showClearButton = false,
                )
            )
        }
    }

    private fun updateContent(block: StoreUiState.Content.() -> StoreUiState.Content) {
        _state.value = block(content)
    }
}
