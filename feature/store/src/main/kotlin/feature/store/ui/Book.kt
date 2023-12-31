package feature.store.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun Book(book: BookState) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Name(
            modifier = Modifier.weight(1f),
            text = book.name,
        )
        Price(text = book.price)
    }
}

@Composable
private fun ShortName(text: String) = Text(
    modifier = Modifier.width(64.dp),
    text = text,
)

@Composable
private fun Name(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
    )
}

@Composable
private fun Price(text: String) = Text(text = text)

@Preview(showBackground = true)
@Composable
private fun BookPreview() = Book(BookStatePreviewData())
