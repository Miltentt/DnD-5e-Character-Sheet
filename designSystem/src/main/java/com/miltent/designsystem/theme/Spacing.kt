package com.miltent.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
object Spacing {
    val extraSmall: Dp = 4.dp
    val small: Dp = 8.dp
    val semiMedium = 12.dp
    val medium: Dp = 16.dp
    val large: Dp = 24.dp
    val extraLarge: Dp = 32.dp
}

val LocalSpacing = staticCompositionLocalOf { Spacing }