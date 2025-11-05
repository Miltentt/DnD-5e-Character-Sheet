package com.miltent.designsystem.statistics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miltent.designsystem.textfield.PrimaryTextField
import com.miltent.designsystem.theme.DNDSheetTheme
import com.miltent.designsystem.theme.Spacing

private val ATTRIBUTE_MODIFIER_TEXTFIELD_WIDTH = 80.dp

@Composable
fun StatisticsWithModifierTextField(
    modifier: Modifier = Modifier,
    statisticValue: String,
    statisticModifierValue: String,
    statisticName: String,
    onTextChange: (String) -> Unit,
    placeholderText: String? = null,
    isError: Boolean = false,
) {
    Row(horizontalArrangement = Arrangement.spacedBy(Spacing.spacing12), modifier = modifier.widthIn()) {
        PrimaryTextField(
            value = statisticValue, onValueChange = onTextChange,
            labelText = statisticName,
            placeholderText = placeholderText ,
            modifier = Modifier.weight(1f),
            isError = isError,
            isDigitsOnly = true
        )
        PrimaryTextField(
            value = statisticModifierValue, onValueChange = {},
            labelText = "Modifier",
            readOnly = true,
            modifier = Modifier.width(ATTRIBUTE_MODIFIER_TEXTFIELD_WIDTH)
        )
    }
}


@Composable
@Preview
fun StatisticsWithModifierTextFieldPreview() {
    DNDSheetTheme {
        StatisticsWithModifierTextField(
            statisticValue = "12",
            statisticName = "STR",
            onTextChange = {},
            statisticModifierValue = "+4"
        )
    }
}
