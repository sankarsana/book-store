package common.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.first

internal class StoreVersionProvider(
    private val dataStore: DataStore<Preferences>,
) {

    suspend fun getBooksVersion(): Int {
        return dataStore.data.first()[BOOKS_VERSION] ?: DEFAULT_VERSION
    }

    suspend fun setBookVersion(value: Int) {
        dataStore.edit {
            it[BOOKS_VERSION] = value
        }
    }

    private companion object {
        val BOOKS_VERSION = intPreferencesKey("books_version")
        const val DEFAULT_VERSION = 1
    }
}
