package com.miltent.designsystem.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.Spacing
import com.miltent.resources.R as ResR

@Composable
fun InversePrimaryButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    buttonText: String,
    icon: (@Composable () -> Unit)?,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .background(Colors.onPrimary)
            .clickable(onClick = onClick, enabled = enabled)
            .padding(Spacing.semiMedium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = buttonText,
            color = Colors.primary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = Spacing.small)
        )
        if (icon != null) {
            icon()
        }
    }
}

@Preview
@Composable
fun InversePrimaryButton_PREVIEW() {
    InversePrimaryButton(
        modifier = Modifier.fillMaxWidth(),
        enabled = true,
        buttonText = "Primary Button",
        icon = {
            Icon(
                painter = painterResource(ResR.drawable.ic_arrow),
                contentDescription = null,
                tint = Colors.primary
            )
        }
    ) {

    }
}