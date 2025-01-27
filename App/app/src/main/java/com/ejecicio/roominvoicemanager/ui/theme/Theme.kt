package com.example.roomv1.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1E88E5),  // Azul vibrante
    secondary = Color(0xFF43A047), // Verde intenso
    tertiary = Color(0xFFFFC107)   // Amarillo cálido
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1976D2),  // Azul fuerte
    secondary = Color(0xFF388E3C), // Verde oscuro
    tertiary = Color(0xFFFFA000),  // Naranja vibrante

    background = Color(0xFFF5F5F5), // Fondo gris claro
    surface = Color(0xFFFFFFFF),    // Superficie blanca
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.Black,
    onBackground = Color(0xFF212121), // Texto oscuro en fondo claro
    onSurface = Color(0xFF212121)    // Texto oscuro en superficie clara
)

@Composable
fun Roomv1Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,

        content = content
    )
}
