package feature.store.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.data.Book
import common.data.BooksRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

internal class StoreViewModel(
    repository: BooksRepository,
) : ViewModel() {

    private val searchQuery = MutableStateFlow("")

    val state: StateFlow<StoreUiState> = repository.getAllBooks()
        .combine(searchQuery, ::createState)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), StoreUiState.Loading)

    private fun createState(books: List<Book>, query: String): StoreUiState.Content {
        val appBarState = AppBarState(
            query = query,
            showClearButton = query.isNotEmpty()
        )
        return StoreUiState.Content(
            appBarState = appBarState,
            books = books.filterBy(query).map(BooksMapper::toUi),
        )
    }

    private fun List<Book>.filterBy(query: String): List<Book> {
        return if (query.isNotEmpty()) {
            filter { it.name.startsWith(query, ignoreCase = true) }
        } else {
            this
        }
    }

    fun onSearchQueryChanged(query: String) {
        searchQuery.value = query
    }

    fun onClearClick() {
        searchQuery.value = ""
    }
}
