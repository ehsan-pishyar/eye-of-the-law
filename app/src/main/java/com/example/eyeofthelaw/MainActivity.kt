package com.example.eyeofthelaw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.rememberNavController
import com.example.eyeofthelaw.navigation.AppNavigation
import com.example.eyeofthelaw.ui.theme.EyeOfTheLawTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EyeOfTheLawTheme {
                // A surface container using the 'background' color from the theme
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
                    // A surface container using the 'background' color from the theme
                    val navController = rememberNavController()
                    Surface {
                        AppNavigation(navHostController = navController)
                    }
                }
            }
        }
    }
}