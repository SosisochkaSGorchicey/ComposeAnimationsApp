package com.example.composeanimationsapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    background = Black,
    surface = DarkGrey,
    onSurface = Pink,
    onSurfaceVariant = White
)

private val LightColorScheme = lightColorScheme(
    background = Purple,
    surface = Pink,
    onSurface = Black,
    onSurfaceVariant = White
)

@Composable
fun ComposeAnimationsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}