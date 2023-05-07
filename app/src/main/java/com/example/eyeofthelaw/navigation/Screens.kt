package com.example.eyeofthelaw.navigation

sealed class StartScreens(val route: String) {
    object Splash: StartScreens(route = "splash")
    object OnBoarding: StartScreens(route = "on-boarding")
}

sealed class MainScreen(val route: String) {
    object Home: StartScreens(route = "home")
}

sealed class DetailsScreens(val route: String) {
    object NimAshrDotali: DetailsScreens(route = "home/nim-ashr-dolati")
    object Mehrie: DetailsScreens(route = "home/mehrie")
}
