package com.miltent.designsystem.radio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miltent.designsystem.theme.Spacing

@Composable
fun RadioButtonGroup(
    modifier: Modifier = Modifier,
    isScrollable: Boolean = false,
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
    val scrollState = rememberScrollState()
    Column(modifier.fillMaxHeight()) {
        RadioButtonGroupHeader(
            title = title,
            supportingText = supportingText
        )
        Column(modifier = Modifier.
            heightIn(max = 1000.dp)
            .verticalScroll(scrollState, enabled = isScrollable)
        )
        {
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
}

@Immutable
data class RadioButtonGroup(
    val id: String,
    val selected: Boolean,
    val enabled: Boolean = true,
    val content: @Composable () -> Unit,
)