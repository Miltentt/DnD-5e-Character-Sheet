package com.miltent.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

val lightColorScheme = lightColorScheme(
    primary = Colors.primary,
    onPrimary = Colors.onPrimary
)

@Composable
fun DNDSheetTheme(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalSpacing provides Spacing)  {
        MaterialTheme(
            colorScheme = lightColorScheme,
            content = content,
        )
    }
}