package com.example.evalmathieud2.home.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.evalmathieud2.home.ui.components.CharacterRow
import com.example.evalmathieud2.home.ui.viewmodels.HomeScreenViewModel
import androidx.navigation.NavController
import com.example.evalmathieud2.features.home.ui.R
import com.example.evalmathieud2.core.ui.components.ThemeToggleButton
import com.example.evalmathieud2.core.ui.theme.ThemeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel,
    themeViewModel: ThemeViewModel
) {
    val uiState by viewModel.state.collectAsState()
    val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.dragon_ball_characters)) },
                actions = {
                    ThemeToggleButton(
                        isDarkTheme = isDarkTheme,
                        onToggleTheme = { themeViewModel.toggleTheme() }
                    )
                }
            )
        }
    ) { innerPadding ->
        val modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)

        if (uiState.characters.isEmpty()) {
            Box(modifier = modifier, contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(uiState.characters, key = { it.id }) { character ->
                    CharacterRow(
                        character = character,
                        onClick = { navController.navigate("detail_screen") }
                    )
                }
            }
        }
    }
}