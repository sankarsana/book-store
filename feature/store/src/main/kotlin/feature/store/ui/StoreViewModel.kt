package feature.store.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.data.book.BookRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class StoreViewModel(
    private val repository: BookRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<StoreUiState>(StoreUiState.Loading)
    val state: StateFlow<StoreUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            delay(1000)
            val books = repository.getAll().toUi()
            _state.value = StoreUiState.Books(books)
        }
    }
}
