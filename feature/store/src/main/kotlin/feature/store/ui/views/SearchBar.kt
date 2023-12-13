package feature.store.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import feature.store.R
import feature.store.ui.SearchBarState
import feature.store.ui.StoreAction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SearchBar(
    state: SearchBarState,
    onAction: (StoreAction.Search) -> Unit,
) {
    TextField(
        value = state.query,
        onValueChange = { onAction(StoreAction.Search.QueryChanged(it)) },
        singleLine = true,
        placeholder = { Text(text = stringResource(id = R.string.search_place_holder)) },
        leadingIcon = { LeadingIcon() },
        trailingIcon = { ClearButton(state.showClearButton, onAction) },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        shape = RoundedCornerShape(32.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        )
    )
}

@Composable
private fun LeadingIcon() {
    Icon(
        imageVector = Icons.Default.Search,
        contentDescription = null,
        modifier = Modifier.padding(start = 16.dp)
    )
}

@Composable
private fun ClearButton(showClearButton: Boolean, onAction: (StoreAction.Search) -> Unit) {
    if (!showClearButton) return
    IconButton(
        onClick = { onAction(StoreAction.Search.ClearClicked) },
        modifier = Modifier.padding(end = 8.dp)
    ) {
        Icon(imageVector = Icons.Default.Clear, contentDescription = null)
    }
}

@Preview
@Composable
private fun SearchBarPreview() = SearchBar(
    state = SearchBarState(),
    onAction = {}
)
