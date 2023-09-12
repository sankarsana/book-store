package feature.store

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import feature.store.ui.BookItem

@Preview
@Composable
fun Store() {
    LazyColumn {
        item { BookItem() }
        item { BookItem() }
        item { BookItem() }
        item { BookItem() }
    }
}
