package com.miltent.featureCharacterCreation.baseInfo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.miltent.core.compose.ObserveEvents
import com.miltent.designsystem.buttons.ProgressButton
import com.miltent.designsystem.dropdown.Dropdown
import com.miltent.designsystem.statistics.StatisticsWithModifierTextField
import com.miltent.designsystem.textfield.PrimaryLabel
import com.miltent.designsystem.textfield.PrimaryTextField
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.DNDSheetTheme
import com.miltent.designsystem.theme.Spacing
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.featureCharacterCreation.baseInfo.event.BaseInfoEvent
import com.miltent.featureCharacterCreation.baseInfo.intent.BaseInfoIntent
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoUiState
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoViewState
import com.miltent.resources.R as ResR

@Composable
fun BaseInfoScreen(onEvent: (BaseInfoEvent) -> Unit) {
    val viewModel: BaseInfoViewModel = hiltViewModel()
    val viewState = viewModel.viewState.collectAsStateWithLifecycle().value
    ObserveEvents(events = viewModel.event, onEvent = { onEvent(it) })
    BaseInfoScreen(viewModel::setIntent, viewState)
}


@Composable
private fun BaseInfoScreen(onIntent: (BaseInfoIntent) -> Unit, viewState: BaseInfoViewState) {
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
                        )
                        .windowInsetsPadding(WindowInsets.navigationBars)
                    , buttonText = stringResource(ResR.string.common_button_next),
                    onClick = { onIntent.invoke(BaseInfoIntent.OnNextClicked) }
                )
            },
            content = { paddingValues: PaddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
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
                    Dropdown(false, onDismissRequest = {}, contentList = listOf("Fighter"))
                    Dropdown(false, onDismissRequest = {}, contentList = listOf("Dwarf"))
                }
            }
        )
    }
}

@Composable
@Preview
fun BaseInfoScreenPreview() {
    BaseInfoScreen(
        onIntent = {},
        viewState = BaseInfoViewState(
            BaseInfoUiState(
                name = "Tul duru",
                race = Race.Dwarf,
                characterClass = CharacterClass.Fighter,
                strength = 10,
                dexterity = 10,
                constitution = 10,
                intelligence = 10,
                wisdom = 10,
                charisma = 10,
            )
        )
    )
}