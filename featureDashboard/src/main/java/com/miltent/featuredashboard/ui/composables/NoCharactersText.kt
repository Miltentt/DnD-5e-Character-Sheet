package com.miltent.featuredashboard.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.Spacing
import com.miltent.resources.R as ResR

@Composable
@Preview
fun NoCharactersText() {
    Text(
        stringResource(ResR.string.no_characters),
        color = Colors.primary,
        fontSize = 22.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(Spacing.spacing16)
            .background(Colors.onPrimary)
            .padding(8.dp)
    )
}
