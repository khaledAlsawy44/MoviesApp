package com.moviesApp.designSystem.theme

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.app.Activity
import android.os.Build
import android.view.Window
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
    primary = PrimaryColor,
    secondary = SecondaryColor,
    secondaryContainer = SecondaryContainerColor,
    background = DarkColorBackground,
    surface = DarkColorSurface,
    onPrimary = OnPrimaryColor,
    onSecondary = OnPrimaryColor,
    onBackground = DarkColorOnBackground,
    onSurface = DarkColorOnSurface,
    error = ErrorColor,
    onError = OnErrorColor
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    secondary = SecondaryColor,
    secondaryContainer = SecondaryContainerColor,
    background = LightColorBackground,
    surface = LightColorSurface,
    onPrimary = OnPrimaryColor,
    onSecondary = OnPrimaryColor,
    onBackground = LightColorOnBackground,
    onSurface = LightColorOnSurface,
    error = ErrorColor,
    onError = OnErrorColor
)


@Composable
fun MoviesAppTheme(
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
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

fun animateStatusBarColor(window: Window, targetColor: Int, duration: Long) {
    val initialColor = Color(window.statusBarColor)

    val colorAnimator = ValueAnimator.ofObject(ArgbEvaluator(), initialColor.toArgb(), targetColor)
    colorAnimator.duration = duration

    colorAnimator.addUpdateListener { animator ->
        val animatedColor = animator.animatedValue as Int
        window.statusBarColor = animatedColor
    }

    colorAnimator.start()
}

