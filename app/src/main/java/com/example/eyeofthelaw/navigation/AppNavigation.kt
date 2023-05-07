package com.example.eyeofthelaw.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.eyeofthelaw.views.main.HomeScreen
import com.example.eyeofthelaw.views.main.mehrie.MehrieScreen
import com.example.eyeofthelaw.views.main.nim_ashr_dolati.NimAshrDolatiScreen
import com.example.eyeofthelaw.views.start.OnBoardingScreen
import com.example.eyeofthelaw.views.start.SplashScreen

@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(
        route = NavGraph.ROOT,
        navController = navHostController,
        startDestination = NavGraph.START
    ) {
        addStartTopLevel(navController = navHostController)
        addMainTopLevel(navController = navHostController)
    }
}

fun NavGraphBuilder.addStartTopLevel(navController: NavController) {
    navigation(
        route = NavGraph.START,
        startDestination = StartScreens.Splash.route
    ) {
        composable(
            route = StartScreens.Splash.route
        ) {
            SplashScreen(
                toOnBoardingScreen = { navController.navigate(StartScreens.OnBoarding.route) },
                toHomeScreen = { navController.navigate(MainScreen.Home.route) }
            )
        }
        composable(
            route = StartScreens.OnBoarding.route
        ) {
            OnBoardingScreen(
                toHomeScreen = { navController.navigate(MainScreen.Home.route) }
            )
        }
    }
}

fun NavGraphBuilder.addMainTopLevel(navController: NavController) {
    navigation(
        route = NavGraph.MAIN,
        startDestination = MainScreen.Home.route
    ) {
        composable(
            route = MainScreen.Home.route
        ) {
            HomeScreen(
                toNimAshrScreen = { navController.navigate(DetailsScreens.NimAshrDotali.route) },
                toMehrieScreen = { navController.navigate(DetailsScreens.Mehrie.route) }
            )
        }
        composable(
            route = DetailsScreens.NimAshrDotali.route
        ) {
            NimAshrDolatiScreen(
                toHomeScreen = { MainScreen.Home.route }
            )
        }
        composable(
            route = DetailsScreens.Mehrie.route
        ) {
            MehrieScreen(
                toHomeScreen = { MainScreen.Home.route }
            )
        }
    }
}

object NavGraph {
    const val ROOT = "root"
    const val START = "start"
    const val MAIN = "main"
}