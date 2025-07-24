package com.miltent.designsystem.statistics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.miltent.designsystem.textfield.PrimaryLabel
import com.miltent.designsystem.textfield.PrimaryTextField
import com.miltent.designsystem.theme.DNDSheetTheme

@Composable
fun StatisticsWithModifierTextField(
    statisticValue: String,
    statisticName: String,
    statisticsModifier: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row {
        Column {
            Text(text = statisticName)
            Row {
                Text(text = statisticName)
                PrimaryTextField(value = statisticValue, onValueChange = onTextChange)
            }
        }
            Text(text = statisticsModifier)
        }
    }

@Composable
@Preview
fun StatisticsWithModifierTextFieldPreview() {
    DNDSheetTheme {
        StatisticsWithModifierTextField(
            statisticValue = "12",
            statisticName = "STR",
            statisticsModifier = "+2",
            onTextChange = {}
        )
    }
}
