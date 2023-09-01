package feature.store.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun BookItem() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            text = "БГ"
        )
        Column(
            Modifier
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Text(
                modifier = Modifier,
                text = "Бхагавад Гита"
            )
            Text(
                color = Color.Gray,
                text = "Прабхупада"
            )
        }
        Text(text = "108")
    }
}