package feature.store.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

// TODO move to core module
@Composable
@Suppress("UNCHECKED_CAST")
inline fun <reified VM : ViewModel> viewModelWithSavedState(
    crossinline callback: (SavedStateHandle) -> VM
): VM {
    val savedStateOwner = LocalSavedStateRegistryOwner.current
    val fact = object : AbstractSavedStateViewModelFactory(savedStateOwner, null) {
        override fun <VM : ViewModel> create(
            key: String,
            modelClass: Class<VM>,
            handle: SavedStateHandle
        ): VM = callback(handle) as VM

    }
    return viewModel<VM>(factory = fact)
}
