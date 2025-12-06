package com.github.danilodequeiroz.subscribeplayground

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// ===============================================
// 1. Color Definition
// ===============================================

// Primary Colors (Vibrant Blue used for emphasis and 'Following' state)
val PrimaryBlue = Color(0xFF1E88E5)
val LightBlue = Color(0xFF42A5F5)

// Surface and Background Colors
val WhiteBackground = Color(0xFFFFFFFF)
val LightSurface = Color(0xFFF0F0F0) // Color for the search field and unselected chips

// Text and Icon Colors
val TextDark = Color(0xFF212121)
val TextLight = Color(0xFFFFFFFF)
val TextGray = Color(0xFF757575) // For subnames and secondary text

// ===============================================
// 2. Color Scheme Palettes (Light/Dark)
// ===============================================

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,          // Vibrant blue (for selected buttons/tabs)
    onPrimary = TextLight,          // Text on top of primary (White)
    surface = WhiteBackground,      // Main screen background (White)
    onSurface = LightBlue,           // Text on top of surface (Black)
    surfaceVariant = LightSurface,  // Background for search field / unselected chips
    onSurfaceVariant = TextGray,    // Secondary text (Grey)
    background = WhiteBackground,
    secondary = LightBlue           // Used for the lighter blue of the "Seguindo" button
)

private val DarkColorScheme = darkColorScheme(
    primary = LightBlue,
    onPrimary = TextDark,
    surface = Color(0xFF121212),
    onSurface = LightBlue,
    surfaceVariant = Color(0xFF333333),
    onSurfaceVariant = Color(0xFFBBBBBB),
    background = Color(0xFF121212)
)

// ===============================================
// 3. Typography Definition
// ===============================================

val AppTypography = Typography(
    titleLarge = TextStyle( // For the TopBar title "Pedrão Munhoz"
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
    ),
    bodyLarge = TextStyle( // For main usernames (Renan.Kosicki)
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    bodyMedium = TextStyle( // For subnames (Renan Kosicki)
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    labelMedium = TextStyle( // Used for text in buttons and tabs
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
    )
    // Default typography will be used for the rest
)

// ===============================================
// 4. Main Theme Composable
// ===============================================

@Composable
fun PlayGroundTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        // Shapes can be defined here if default shapes need adjustment.
        content = content
    )
}