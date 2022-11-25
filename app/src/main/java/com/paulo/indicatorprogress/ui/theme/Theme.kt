package com.paulo.indicatorprogress.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.paulo.indicatorprogress.allscreen.Dimensions
import com.paulo.indicatorprogress.allscreen.LocalAppDimens
import com.paulo.indicatorprogress.allscreen.LocalOrientationMode
import com.paulo.indicatorprogress.allscreen.Orientation
import com.paulo.indicatorprogress.allscreen.ProvideAppUtils
import com.paulo.indicatorprogress.allscreen.WindowSize
import com.paulo.indicatorprogress.allscreen.WindowSizeClass
import com.paulo.indicatorprogress.allscreen.compactDimensions
import com.paulo.indicatorprogress.allscreen.largeDimensions
import com.paulo.indicatorprogress.allscreen.mediumDimensions
import com.paulo.indicatorprogress.allscreen.smallDimensions

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun IndicatorProgressTheme(
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
        typography = Typography(),
        shapes = Shapes,
        content = content
    )
}

@Composable
fun DifferentScreenSizesYTTheme(
    windowSizeClass: WindowSizeClass,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val orientation = when{
        windowSizeClass.width.size > windowSizeClass.height.size -> Orientation.Landscape
        else -> Orientation.Portrait
    }

    val sizeThatMatters = when(orientation){
        Orientation.Portrait -> windowSizeClass.width
        else -> windowSizeClass.height
    }

    val dimensions = when(sizeThatMatters){
        is WindowSize.Small -> smallDimensions
        is WindowSize.Compact -> compactDimensions
        is WindowSize.Medium -> mediumDimensions
        else -> largeDimensions
    }

    val typography = when(sizeThatMatters){
        is WindowSize.Small -> typographySmall
        is WindowSize.Compact -> typographyCompact
        is WindowSize.Medium -> typographyMedium
        else -> typographyBig
    }

    ProvideAppUtils(dimensions = dimensions, orientation = orientation) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = Shapes,
            content = content
        )
    }
}
object AppTheme{
    val dimens:Dimensions
        @Composable
        get() = LocalAppDimens.current

    val orientation:Orientation
        @Composable
        get() = LocalOrientationMode.current
}