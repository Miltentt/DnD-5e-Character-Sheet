package com.miltent.designsystem.radio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.miltent.designsystem.theme.DNDSheetTheme
import com.miltent.designsystem.theme.Spacing

@Composable
fun RadioButtonGroupHeader(
    title: String,
    supportingText: String?,
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
        )
        supportingText?.let { supportingText ->
            Text(
                text = supportingText,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(Spacing.spacing4)
            )
        }
    }
}

@Preview
@Composable
fun RadioButtonGroupHeaderPreview() {
    DNDSheetTheme {
        RadioButtonGroupHeader(
            title = "Title",
            supportingText = "Supporting text"
        )
    }
}