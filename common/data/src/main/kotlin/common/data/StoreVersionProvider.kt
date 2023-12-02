package common.data

import android.content.SharedPreferences

internal class StoreVersionProvider(
    private val appPrefs: SharedPreferences,
) {

    fun get(): Int {
        return appPrefs.getInt(VERSION_KEY, DEFAULT_VERSION)
    }

    private companion object {
        const val VERSION_KEY = "database_version"
        const val DEFAULT_VERSION = 1
    }
}
