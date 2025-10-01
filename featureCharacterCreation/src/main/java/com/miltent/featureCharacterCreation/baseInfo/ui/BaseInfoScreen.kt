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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.miltent.core.compose.ObserveEvents
import com.miltent.designsystem.buttons.ProgressButton
import com.miltent.designsystem.formatter.CharacterClassFormatter
import com.miltent.designsystem.formatter.RaceFormatter
import com.miltent.designsystem.radio.RadioButtonGroup
import com.miltent.designsystem.statistics.StatisticsWithModifierTextField
import com.miltent.designsystem.textfield.PrimaryTextField
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.DNDSheetTheme
import com.miltent.designsystem.theme.Spacing
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.domain.model.StatisticType
import com.miltent.featureCharacterCreation.baseInfo.event.BaseInfoEvent
import com.miltent.featureCharacterCreation.baseInfo.intent.BaseInfoIntent
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoUiState
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoViewState
import com.miltent.featureCharacterCreation.baseInfo.validator.ValidationError
import com.miltent.resources.R as ResR

@Composable
fun BaseInfoScreen(onEvent: (BaseInfoEvent) -> Unit) {
    val viewModel: BaseInfoViewModel = hiltViewModel()
    val viewState = viewModel.viewState.collectAsState().value
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
                        .windowInsetsPadding(WindowInsets.navigationBars)
                        .padding(
                            start = Spacing.spacing4,
                            bottom = Spacing.spacing16,
                            end = Spacing.spacing4
                        ),
                    buttonText = stringResource(ResR.string.common_button_next),
                    onClick = { onIntent.invoke(BaseInfoIntent.OnNextClicked) }
                )
            },
            content = { paddingValues: PaddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .verticalScroll(rememberScrollState())
                        .padding(Spacing.spacing16),
                    verticalArrangement = Arrangement.spacedBy(
                        Spacing.spacing16
                    )
                ) {
                    PrimaryTextField(
                        value = viewState.uiState.name,
                        onValueChange = { newName ->
                            onIntent.invoke(BaseInfoIntent.OnNameChanged(newName))
                        },
                        readOnly = false,
                        labelText = stringResource(ResR.string.character_creation_name),
                        placeholderText = stringResource(ResR.string.character_creation_name_placeholder),
                        isError = viewState.uiState.error == ValidationError.EmptyName
                    )
                    StatisticsWithModifierTextField(
                        statisticValue = viewState.uiState.strength.value.toString(),
                        statisticName = stringResource(ResR.string.statistic_short_strength),
                        statisticModifierValue = viewState.uiState.strength.calculateModifier()
                            .toString(),
                        onTextChange = {
                            onIntent.invoke(
                                BaseInfoIntent.OnStatisticChanged(
                                    statisticType = StatisticType.STR,
                                    statisticValue = it
                                )
                            )
                        },
                        isError = viewState.uiState.error == ValidationError.StrengthTooHigh
                    )
                    StatisticsWithModifierTextField(
                        statisticValue = viewState.uiState.intelligence.value.toString(),
                        statisticName = stringResource(ResR.string.statistic_short_intelligence),
                        statisticModifierValue = viewState.uiState.intelligence.calculateModifier()
                            .toString(),
                        onTextChange = {
                            onIntent.invoke(
                                BaseInfoIntent.OnStatisticChanged(
                                    statisticType = StatisticType.INT,
                                    statisticValue = it
                                )
                            )
                        },
                        isError = viewState.uiState.error == ValidationError.IntelligenceTooHigh
                    )
                    StatisticsWithModifierTextField(
                        statisticValue = viewState.uiState.dexterity.value.toString(),
                        statisticName = stringResource(ResR.string.statistic_short_dexterity),
                        statisticModifierValue = viewState.uiState.dexterity.calculateModifier()
                            .toString(),
                        onTextChange = {
                            onIntent.invoke(
                                BaseInfoIntent.OnStatisticChanged(
                                    statisticType = StatisticType.DEX,
                                    statisticValue = it
                                )
                            )
                        },
                        isError = viewState.uiState.error == ValidationError.DexterityTooHigh
                    )
                    StatisticsWithModifierTextField(
                        statisticValue = viewState.uiState.charisma.value.toString(),
                        statisticName = "CHAR",
                        statisticModifierValue = viewState.uiState.charisma.calculateModifier()
                            .toString(),
                        onTextChange = {
                            onIntent.invoke(
                                BaseInfoIntent.OnStatisticChanged(
                                    statisticType = StatisticType.CHA,
                                    statisticValue = it
                                )
                            )
                        },
                        isError = viewState.uiState.error == ValidationError.CharismaTooHigh
                    )
                    StatisticsWithModifierTextField(
                        statisticValue = viewState.uiState.constitution.value.toString(),
                        statisticName = stringResource(ResR.string.statistic_short_constitution),
                        statisticModifierValue = viewState.uiState.constitution.calculateModifier()
                            .toString(),
                        onTextChange = {
                            onIntent.invoke(
                                BaseInfoIntent.OnStatisticChanged(
                                    statisticType = StatisticType.CON,
                                    statisticValue = it
                                )
                            )
                        },
                        isError = viewState.uiState.error == ValidationError.ConstitutionTooHigh
                    )
                    StatisticsWithModifierTextField(
                        statisticValue = viewState.uiState.wisdom.value.toString(),
                        statisticName = stringResource(ResR.string.statistic_short_wisdom),
                        statisticModifierValue = viewState.uiState.wisdom.calculateModifier()
                            .toString(),
                        onTextChange = {
                            onIntent.invoke(
                                BaseInfoIntent.OnStatisticChanged(
                                    statisticType = StatisticType.WIS,
                                    statisticValue = it
                                )
                            )
                        },
                        isError = viewState.uiState.error == ValidationError.WisdomTooHigh
                    )
                    RadioButtonGroup(
                        modifier = Modifier.fillMaxWidth(),
                        title = stringResource(ResR.string.base_info_choose_race_title),
                        supportingText = stringResource(ResR.string.base_info_choose_race_subtitle),
                        isError = viewState.uiState.error == ValidationError.EmptyRace,
                        fillContentWidth = true,
                        onClick = { raceIdentifier -> onIntent.invoke(BaseInfoIntent.OnRaceChosen(raceIdentifier)) },
                        groupRadioButtons = Race.entries.map { race ->
                            RadioButtonGroup(
                                id = race.identifier,
                                selected = viewState.uiState.race == race,
                                content = { Text(text = stringResource(RaceFormatter.formatRace(race))) }
                            )
                        }
                    )

                    RadioButtonGroup(
                        modifier = Modifier.fillMaxWidth(),
                        title = stringResource(ResR.string.base_info_choose_class_title),
                        supportingText = stringResource(ResR.string.base_info_choose_class_subtitle),
                        fillContentWidth = true,
                        isError = viewState.uiState.error == ValidationError.EmptyClass,
                        onClick = {
                            onIntent.invoke(
                                BaseInfoIntent.OnCharacterClassChosen(
                                    CharacterClass.Fighter(1)
                                )
                            )
                        },
                        groupRadioButtons = listOf(
                            RadioButtonGroup(
                                id = CharacterClass.Fighter.identifier,
                                selected = viewState.uiState.characterClass?.let { it::class == CharacterClass.Fighter::class } == true,
                                content = { Text(text = stringResource(CharacterClassFormatter.formatCharacterClass(CharacterClass.Fighter::class))) }
                            ),
                        )
                    )
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
                characterClass = CharacterClass.Fighter(8),
                strength = Attribute(10),
                dexterity = Attribute(10),
                constitution = Attribute(10),
                intelligence = Attribute(10),
                wisdom = Attribute(10),
                charisma = Attribute(10),
                error = null
            )
        )
    )
}