@file:OptIn(ExperimentalMaterial3Api::class)

package feature.store.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import feature.store.R
import feature.store.ui.AppBarState

@Composable
internal fun AppBar(
    state: AppBarState,
    onSearchIconClick: () -> Unit,
    onClearClick: () -> Unit
): @Composable () -> Unit = {
    when (state) {
        is AppBarState.Main -> AppBarMain(
            state = state,
            onSearchIconClick = onSearchIconClick,
        )

        is AppBarState.Search -> AppBarSearch(
            state = state,
            onClearClick = onClearClick,
        )
    }
}

@Composable
private fun AppBarMain(
    state: AppBarState,
    onSearchIconClick: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_bar_title)) },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = onSearchIconClick) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
        },
    )
}

@Composable
private fun AppBarSearch(
    state: AppBarState,
    onClearClick: () -> Unit = {}
) {
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        query = "",
        onQueryChange = {},
        onSearch = {},
        active = false,
        onActiveChange = {},
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        trailingIcon = {
            IconButton(onClick = onClearClick) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = null)
            }
        }
    ) {

    }
}

@Preview
@Composable
private fun AppBarMainPreview() {
    AppBarMain(state = AppBarState.Main)
}

@Preview
@Composable
private fun AppBarMainSearch() {
    AppBarSearch(state = AppBarState.Search)
}
