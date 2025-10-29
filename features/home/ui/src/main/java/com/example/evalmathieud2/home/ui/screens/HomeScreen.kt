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
import com.example.evalmathieud2.home.ui.components.CharacterRow
import com.example.evalmathieud2.home.ui.viewmodels.HomeScreenViewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController,viewModel: HomeScreenViewModel) {
    val uiState by viewModel.state.collectAsState()

    Scaffold{ innerPadding ->
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