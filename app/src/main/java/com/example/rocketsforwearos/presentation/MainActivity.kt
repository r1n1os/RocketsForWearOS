/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.rocketsforwearos.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.rocketsforwearos.presentation.theme.RocketsForWearOsTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.rocketsforwearos.presentation.rocket_details_screen.RocketDetailsScreen
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.rocketsforwearos.presentation.rockets_list_screen.RocketsListScreen
import androidx.compose.material3.Surface

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    RocketsForWearOsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = Color.DarkGray
        ) {
            val navController = rememberSwipeDismissableNavController()
            SwipeDismissableNavHost(
                navController = navController,
                startDestination = ScreensRoutes.RocketsListScreen.route
            ) {
                composable(
                    route = ScreensRoutes.RocketsListScreen.route
                ) {
                    RocketsListScreen(navController)
                }
                composable(
                    route = ScreensRoutes.RocketDetailsScreen.route + "/{rocket_id_key}"
                ) {
                    RocketDetailsScreen()
                }
            }
        }
    }
}
