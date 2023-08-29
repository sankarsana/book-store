package common.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import common.navigation.Screen
import feature.store.Store

@Composable
fun NavigationSetup() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Store.name) {
        composable(Screen.Store.name) {
            Store()
        }
    }
}
