package com.pbaileyapps.layoutbasics.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = grey500,
    primaryVariant = grey700,
    secondary = grey500,
    secondaryVariant = grey300,
    background = black,
    onBackground = grey100,
    surface = grey900
)

private val LightColorPalette = lightColors(
    primary = grey700,
    primaryVariant = grey900,
    secondary = grey700,
    secondaryVariant = grey900,
    background = white,
    onBackground = grey900,
    surface = grey100
)

@Composable
fun LayoutBasicsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}