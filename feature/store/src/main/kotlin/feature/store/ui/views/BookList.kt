package feature.store.ui.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import feature.store.ui.Book
import feature.store.ui.BookState
import feature.store.ui.BookStatePreviewData

@Composable
internal fun BookList(books: List<BookState>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(items = books) {
            Book(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookListPreview() = BookList(
    books = listOf(BookStatePreviewData(), BookStatePreviewData(), BookStatePreviewData())
)
