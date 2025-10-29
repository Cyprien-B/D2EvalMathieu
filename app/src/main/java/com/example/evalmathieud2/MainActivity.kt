package com.example.evalmathieud2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evalmathieud2.home.charactersModule
import com.example.evalmathieud2.home.ui.screens.DetailScreen
import com.example.evalmathieud2.home.ui.screens.HomeScreen
import com.example.evalmathieud2.home.ui.screens.ListScreen
import com.example.evalmathieud2.ui.theme.EvalMathieuD2Theme
import com.example.evalmathieud2.home.ui.viewmodels.HomeScreenViewModel
import org.koin.core.context.startKoin
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            modules(charactersModule)
        }
        enableEdgeToEdge()
        setContent {
            EvalMathieuD2Theme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.HOMESCREEN
                ) {
                    composable(Routes.HOMESCREEN) {
                        val viewModel = viewModel{HomeScreenViewModel()}
                        HomeScreen(navController, viewModel)
                    }
                    composable(Routes.LISTSCREEN) {
                        ListScreen(navController)
                    }
                    composable(Routes.DETAILSCREEN) {
                        DetailScreen(navController)
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EvalMathieuD2Theme {
        Greeting("Android")
    }
}