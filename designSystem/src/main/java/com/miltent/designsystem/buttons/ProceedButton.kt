package com.miltent.designsystem.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.Spacing
import com.miltent.resources.R as ResR

@Composable
fun ProgressButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    buttonText: String,
    onClick: () -> Unit
) {
    InversePrimaryButton(
        modifier = modifier,
        enabled = enabled,
        buttonText = buttonText,
        onClick = onClick,
        icon = {
            Icon(
                modifier = Modifier.background(color = Colors.primary).padding(Spacing.spacing8),
                painter = painterResource(ResR.drawable.ic_arrow),
                contentDescription = null,
                tint = Colors.onPrimary
            )
        })
}

@Preview
@Composable
fun ProgressButton_PREVIEW() {
    ProgressButton(
        modifier = Modifier.fillMaxWidth(),
        enabled = true,
        buttonText = "Progress Button",
    ) {

    }
}