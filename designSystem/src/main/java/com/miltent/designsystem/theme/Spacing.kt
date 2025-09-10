package com.miltent.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
object Spacing {
    val spacing0: Dp = 0.dp
    val spacing4: Dp = 4.dp
    val spacing8: Dp = 8.dp
    val spacing12 = 12.dp
    val spacing16: Dp = 16.dp
    val spacing24: Dp = 24.dp
    val spacing32: Dp = 32.dp
}

val LocalSpacing = staticCompositionLocalOf { Spacing }