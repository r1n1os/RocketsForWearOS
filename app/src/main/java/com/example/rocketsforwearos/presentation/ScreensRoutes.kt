package com.example.rocketsforwearos.presentation

sealed class ScreensRoutes(val route: String) {
    object RocketsListScreen : ScreensRoutes("rockets_list_screen")
    object RocketDetailsScreen : ScreensRoutes("rockets_details_screen")
}