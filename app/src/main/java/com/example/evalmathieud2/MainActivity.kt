package com.example.evalmathieud2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evalmathieud2.home.ui.screens.DetailScreen
import com.example.evalmathieud2.home.ui.screens.HomeScreen
import com.example.evalmathieud2.ui.theme.EvalMathieuD2Theme
import com.example.evalmathieud2.home.ui.viewmodels.HomeScreenViewModel
import com.example.evalmathieud2.core.ui.theme.ThemeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            // Le ThemeViewModel gère l'état du thème (clair/sombre).
            val themeViewModel: ThemeViewModel = viewModel()
            val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()

            EvalMathieuD2Theme(darkTheme = isDarkTheme, dynamicColor = false) {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.HOMESCREEN
                ) {
                    composable(Routes.HOMESCREEN) {
                        val homeViewModel = viewModel{HomeScreenViewModel()}
                        HomeScreen(
                            navController = navController,
                            viewModel = homeViewModel,
                            themeViewModel = themeViewModel
                        )
                    }
                    composable(Routes.DETAILSCREEN) {
                        DetailScreen(navController)
                    }

                }
            }
        }
    }
}