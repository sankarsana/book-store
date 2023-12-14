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
) : ViewModel(), EventHandler<StoreEvent> {

    private val searchQuery = MutableStateFlow("")

    val state: StateFlow<StoreState> = repository.getAllBooks()
        .combine(searchQuery, ::createState)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), StoreState.Loading)

    private fun createState(books: List<Book>, query: String): StoreState {
        if (books.isEmpty()) return StoreState.Empty
        val searchState = SearchState(
            query = query,
            showClearButton = query.isNotEmpty()
        )
        return StoreState.Content(
            searchState = searchState,
            books = filterBooksUseCase(books, query).map(BooksMapper::toUi),
        )
    }

    override fun obtainEvent(event: StoreEvent) {
        when (event) {
            is StoreEvent.Search.ClearClicked -> searchQuery.value = ""
            is StoreEvent.Search.QueryChanged -> searchQuery.value = event.query
        }
    }
}
