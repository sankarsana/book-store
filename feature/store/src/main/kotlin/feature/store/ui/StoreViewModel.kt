package feature.store.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.data.Book
import common.data.BooksRepository
import feature.store.domain.FilterBooksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

internal class StoreViewModel(
    repository: BooksRepository,
    private val filterBooksUseCase: FilterBooksUseCase,
) : ViewModel() {

    private val searchQuery = MutableStateFlow("")

    val state: StateFlow<StoreState> = repository.getAllBooks()
        .combine(searchQuery, ::createState)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), StoreState.Loading)

    private fun createState(books: List<Book>, query: String): StoreState.Content {
        val searchBarState = SearchBarState(
            query = query,
            showClearButton = query.isNotEmpty()
        )
        return StoreState.Content(
            searchBarState = searchBarState,
            books = filterBooksUseCase(books, query).map(BooksMapper::toUi),
        )
    }

    fun onAction(action: StoreAction) {
        when (action) {
            is StoreAction.Search.ClearClicked -> searchQuery.value = ""
            is StoreAction.Search.QueryChanged -> searchQuery.value = action.query
        }
    }
}
