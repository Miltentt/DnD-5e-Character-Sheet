package com.miltent.designsystem.radio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.miltent.designsystem.theme.Spacing

@Composable
fun RadioButtonGroup(
    modifier: Modifier = Modifier,
    groupRadioButtons: List<RadioButtonGroup>,
    title: String,
    supportingText: String?,
    onClick: (id: String) -> Unit,
    radioButtonVerticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    radioButtonContentPaddingValues: PaddingValues = PaddingValues(),
    fillContentWidth: Boolean = false,
    radioButtonInnerPaddingValues: PaddingValues = PaddingValues(
        start = Spacing.spacing0,
        top = Spacing.spacing8,
        end = Spacing.spacing8,
        bottom = Spacing.spacing8
    ),
    isError: Boolean = false
) {
    Column(modifier) {
        RadioButtonGroupHeader(
            title = title,
            supportingText = supportingText
        )
        groupRadioButtons.forEach { radioButtonGroup ->
            RadioButtonWithContent(
                selected = radioButtonGroup.selected,
                enabled = radioButtonGroup.enabled,
                onClick = { onClick.invoke(radioButtonGroup.id) },
                verticalAlignment = radioButtonVerticalAlignment,
                radioButtonContentPaddingValues = radioButtonContentPaddingValues,
                innerPaddingValues = radioButtonInnerPaddingValues,
                isError = isError,
                modifier = Modifier.padding(Spacing.spacing8).run {
                    if (fillContentWidth) fillMaxWidth() else this
                },
                content = {
                    radioButtonGroup.content()
                }
            )
        }
    }

}

@Immutable
data class RadioButtonGroup(
    val id: String,
    val selected: Boolean,
    val enabled: Boolean = true,
    val content: @Composable () -> Unit,
)