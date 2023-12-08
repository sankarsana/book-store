package feature.store.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import feature.store.R
import feature.store.ui.AppBarState

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun AppBarSearch(
    state: AppBarState,
    onClearClick: () -> Unit = {},
    onQueryChange: (String) -> Unit = {},
) {
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        query = state.query,
        onQueryChange = onQueryChange,
        onSearch = {},
        active = false,
        onActiveChange = {},
        placeholder = { Text(text = stringResource(id = R.string.search_place_holder)) },
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        trailingIcon = {
            if (state.showClearButton) {
                IconButton(onClick = onClearClick) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                }
            }
        },
        content = {}
    )
}

@Preview
@Composable
private fun AppBarMainSearch() {
    AppBarSearch(AppBarState())
}
