package feature.store.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import feature.store.BookUiItem

@Composable
fun BookItem(item: BookUiItem = createBookUiItem()) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ShortName(text = "БГ")
        Name(
            modifier = Modifier.weight(1f),
            text = "Бхагавад Гита"
        )
        Price()
    }
}

@Composable
private fun ShortName(text: String) = Text(
    fontSize = 20.sp,
    fontWeight = FontWeight.Medium,
    text = text
)

@Composable
private fun Name(modifier: Modifier, text: String) {
    val textModifier = modifier.padding(start = 16.dp)
    Text(
        modifier = textModifier,
        text = text,
    )
}

@Composable
private fun Price() = Text(text = "350")

@Preview
@Composable
private fun BookItemPreview() = BookItem(item = createBookUiItem())

private fun createBookUiItem() = BookUiItem(
    shortName = "БГ",
    name = "Бхагавад Гита",
    price = "350",
)
