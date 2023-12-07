package feature.store.ui

internal sealed interface AppBarState {
    data object Main : AppBarState
    data object Search : AppBarState
}
