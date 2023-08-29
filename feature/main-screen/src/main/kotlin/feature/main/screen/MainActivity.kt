package feature.main.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import common.navigation.graph.NavigationSetup
import common.ui.theme.BookStoreTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookStoreTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavigationSetup()
                }
            }
        }
    }
}
