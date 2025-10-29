package com.example.evalmathieud2.core.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import com.example.evalmathieud2.core.ui.R

@Suppress("unused")
@Composable
fun EvalMathieuD2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> {
            // Utilise les ressources de couleurs déclarées dans res/values/colors.xml pour le thème sombre
            val primary = colorResource(id = R.color.purple_80)
            val secondary = colorResource(id = R.color.purple_grey_80)
            val tertiary = colorResource(id = R.color.pink_80)
            darkColorScheme(
                primary = primary,
                secondary = secondary,
                tertiary = tertiary
            )
        }

        else -> {
            // Utilise les ressources de couleurs déclarées dans res/values/colors.xml pour le thème clair
            val primary = colorResource(id = R.color.purple_40)
            val secondary = colorResource(id = R.color.purple_grey_40)
            val tertiary = colorResource(id = R.color.pink_40)
            lightColorScheme(
                primary = primary,
                secondary = secondary,
                tertiary = tertiary
            )
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}