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
import com.miltent.domain.model.Attributes
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
                        isError = ValidationError.EmptyName in viewState.uiState.errors,
                        modifier = Modifier
                    )
                    StatisticType.entries.toSet().forEach { statisticType ->
                        StatisticsWithModifierTextField(
                            statisticValue = viewState.uiState.attributesIncomplete
                                .getValue(statisticType)?.value?.toString() ?: "",
                            statisticName = statisticType.name,
                            statisticModifierValue = viewState.uiState.attributesIncomplete
                                .getValue(statisticType)?.calculateModifier()?.toString() ?: "",
                            onTextChange = { text ->
                                val attributeValue =
                                    if(text.isEmpty()) null
                                    else Attribute(text.toInt())
                                onIntent.invoke(
                                    BaseInfoIntent.OnStatisticsChanged(
                                        statisticType, attributeValue
                                    )
                                )
                            },
                            isError = ValidationError.AttributeOutOfRange(statisticType) in viewState.uiState.errors
                                    || ValidationError.EmptyAttribute(statisticType) in viewState.uiState.errors

                        )
                    }
                    RadioButtonGroup(
                        modifier = Modifier.fillMaxWidth(),
                        title = stringResource(ResR.string.base_info_choose_race_title),
                        supportingText = stringResource(ResR.string.base_info_choose_race_subtitle),
                        isError = ValidationError.EmptyRace in viewState.uiState.errors,
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
                        isError = ValidationError.EmptyClass in viewState.uiState.errors,
                        onClick = { characterClassIdentifier ->
                            onIntent.invoke(
                                BaseInfoIntent.OnCharacterClassChosen(
                                    characterClassIdentifier
                                )
                            )
                        },
                        groupRadioButtons = CharacterClass.subClasses
                            .map { characterClass ->
                            RadioButtonGroup(
                                id = characterClass.identifier,
                                selected = viewState.uiState.characterClass?.identifier == characterClass.identifier,
                                content = {
                                    Text(text = stringResource(
                                        CharacterClassFormatter.formatCharacterClass(characterClass::class)
                                        )
                                    )
                                }
                            )
                        },
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
                attributesIncomplete = Attributes.attributesIncomplete,
                errors = emptyList()
            )
        )
    )
}