package com.miltent.featureCharacterCreation.baseInfo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.miltent.designsystem.buttons.ProgressButton
import com.miltent.designsystem.dropdown.Dropdown
import com.miltent.designsystem.statistics.StatisticsWithModifierTextField
import com.miltent.designsystem.textfield.PrimaryLabel
import com.miltent.designsystem.textfield.PrimaryTextField
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.DNDSheetTheme
import com.miltent.designsystem.theme.Spacing
import com.miltent.resources.R as ResR

@Composable
fun BaseInfoScreen() {
    DNDSheetTheme {
        Scaffold(
            modifier = Modifier.background(Colors.primary),
            bottomBar = {
                ProgressButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = Spacing.spacing4,
                            bottom = Spacing.spacing16,
                            end = Spacing.spacing4
                        ), buttonText = stringResource(ResR.string.button_create_character),
                    onClick = { }
                )
            },
            content = { paddingValues: PaddingValues ->
                Column(
                    modifier = Modifier.padding(paddingValues),
                    verticalArrangement = Arrangement.spacedBy(
                        Spacing.spacing16
                    )
                ) {
                    PrimaryTextField(value = "Tul duru", onValueChange = {}, label = {
                        PrimaryLabel("Imię")
                    })
                    StatisticsWithModifierTextField(
                        statisticValue = "10",
                        statisticName = "STR",
                        statisticsModifier = "+3",
                        onTextChange = {})
                    StatisticsWithModifierTextField(
                        statisticValue = "10",
                        statisticName = "INT",
                        statisticsModifier = "+3",
                        onTextChange = {})
                    StatisticsWithModifierTextField(
                        statisticValue = "10",
                        statisticName = "DEX",
                        statisticsModifier = "+3",
                        onTextChange = {})
                    StatisticsWithModifierTextField(
                        statisticValue = "10",
                        statisticName = "CHAR",
                        statisticsModifier = "+3",
                        onTextChange = {})
                    StatisticsWithModifierTextField(
                        statisticValue = "10",
                        statisticName = "CON",
                        statisticsModifier = "+3",
                        onTextChange = {})
                    StatisticsWithModifierTextField(
                        statisticValue = "10",
                        statisticName = "WIS",
                        statisticsModifier = "+3",
                        onTextChange = {})
                    Dropdown(true, onDismissRequest = {}, contentList = listOf("Fighter"))
                    Dropdown(true, onDismissRequest = {}, contentList = listOf("Dwarf"))
                }
            }
        )
    }
}

@Composable
@Preview
fun BaseInfoScreenPreview() {
    BaseInfoScreen()
}