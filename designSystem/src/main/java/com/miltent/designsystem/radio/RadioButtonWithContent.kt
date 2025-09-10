package com.miltent.designsystem.radio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.DNDSheetTheme
import com.miltent.designsystem.theme.Spacing

@Composable
fun RadioButtonWithContent(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    content: @Composable () -> Unit,
    innerPaddingValues: PaddingValues = PaddingValues(Spacing.spacing8),
    isError: Boolean = false,
    radioButtonContentPaddingValues: PaddingValues = PaddingValues(),
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(Spacing.spacing16),
        modifier = modifier
            .selectable(
                selected = selected,
                enabled = enabled,
                role = Role.Button,
                onClick = onClick
            )
            .padding(innerPaddingValues),
        verticalAlignment = verticalAlignment,

        ) {
        RadioButton(
            selected = selected,
            onClick = null,
            enabled = enabled,
            colors = RadioButtonDefaults.colors(
                unselectedColor = if (isError) Colors.error else Colors.primary,
            ),
            modifier = Modifier.padding(radioButtonContentPaddingValues)
        )
        content()
    }
}

@Composable
@Preview
fun RadioButtonWithContentPreview() {
    DNDSheetTheme {
        RadioButtonWithContent(
            selected = true,
            onClick = {},
            content = {
                Text(text = "Text")
            }
        )
    }
}