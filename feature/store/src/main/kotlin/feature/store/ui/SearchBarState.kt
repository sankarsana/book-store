package feature.store.ui

internal data class SearchBarState(
    val query: String = "",
    val showClearButton: Boolean = false,
)
