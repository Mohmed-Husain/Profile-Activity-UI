package com.husain.mykotlin.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = BackgroundDark,
    onPrimary = Color.White,
    surface = CardBackground,
    onSurface = Color.White,
    background = BackgroundDark,
    onBackground = Color.White
)

@Composable
fun MyKotlinTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        content = content
    )
}