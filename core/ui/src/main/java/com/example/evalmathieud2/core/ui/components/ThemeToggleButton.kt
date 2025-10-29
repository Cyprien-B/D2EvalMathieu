package com.example.evalmathieud2.core.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Bouton pour basculer entre le thème clair et sombre
 *
 * @param isDarkTheme État actuel du thème (true = sombre, false = clair)
 * @param onToggleTheme Fonction appelée quand on clique sur le bouton
 * @param modifier Modificateur optionnel pour personnaliser le bouton
 */
@Composable
fun ThemeToggleButton(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onToggleTheme,
        modifier = modifier
    ) {
        Text(text = if (isDarkTheme) "☀️" else "🌙")
    }
}
