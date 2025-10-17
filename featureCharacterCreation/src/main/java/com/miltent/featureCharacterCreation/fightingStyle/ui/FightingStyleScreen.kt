package com.miltent.featureCharacterCreation.fightingStyle.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
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
import com.miltent.designsystem.radio.RadioButtonGroup
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.DNDSheetTheme
import com.miltent.designsystem.theme.Spacing
import com.miltent.domain.model.SpecialAbility
import com.miltent.domain.model.SpecialAbilityType
import com.miltent.featureCharacterCreation.baseInfo.intent.BaseInfoIntent
import com.miltent.featureCharacterCreation.fightingStyle.event.FightingStyleEvent
import com.miltent.featureCharacterCreation.fightingStyle.intent.FightingStyleIntent
import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleUiState
import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleViewState
import com.miltent.featureCharacterCreation.fightingStyle.validation.ValidationError
import com.miltent.resources.R as ResR

@Composable
fun FightingStyleScreen(onEvent: (FightingStyleEvent) -> Unit) {
    val viewModel: FightingStyleViewModel = hiltViewModel()
    val viewState = viewModel.viewState.collectAsState().value
    ObserveEvents(events = viewModel.event, onEvent = { onEvent(it) })
    FightingStyleScreen(viewModel::setIntent, viewState = viewState)
}

@Composable
private fun FightingStyleScreen(
    onIntent: (FightingStyleIntent) -> Unit,
    viewState: FightingStyleViewState
) {
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
                    onClick = { onIntent.invoke(FightingStyleIntent.OnNextClicked) }
                )
            },
            content = { paddingValues: PaddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(Spacing.spacing16)
                ) {
                    RadioButtonGroup(
                        modifier = Modifier.fillMaxWidth(),
                        title = stringResource(ResR.string.fighting_style_title),
                        supportingText = stringResource(ResR.string.fighting_style_subtitle),
                        fillContentWidth = true,
                        isError = viewState.uiState.error == ValidationError.EmptyFightingStyle,
                        onClick = {
                            onIntent.invoke(FightingStyleIntent.OnFightingStyleChosen(it))
                        },
                        groupRadioButtons = viewState.fightingStyles.map { fightingStyle ->
                            RadioButtonGroup(
                                id = fightingStyle.id,
                                selected = viewState.uiState.currentFightingStyle?.id == fightingStyle.id,
                                content = {
                                    Column {
                                        Text(text = fightingStyle.name)
                                        Text(text = fightingStyle.description)
                                    }
                                }
                            )
                        }
                    )
                }
            }
        )
    }
}

@Composable
@Preview
fun FightingStyleScreenPreview() {
    FightingStyleScreen(
        viewState = FightingStyleViewState(
            uiState = FightingStyleUiState(
                currentFightingStyle = null,
                error = null
            ),
            fightingStyles = listOf(
                SpecialAbility(
                    name = "test ability 1",
                    description = "test description 1",
                    type = SpecialAbilityType.FightingStyle,
                    id = "1"
                ),
                SpecialAbility(
                    name = "test ability 2",
                    description = "test description 2",
                    id = "2",
                    type = SpecialAbilityType.FightingStyle,
                ),
                SpecialAbility(
                    name = "test ability 3",
                    description = "test description 3",
                    id = "3",
                    type = SpecialAbilityType.FightingStyle,
                ),
                SpecialAbility(
                    name = "test ability 4",
                    description = "test description 4",
                    id = "4",
                    type = SpecialAbilityType.FightingStyle,
                ),
            )
        ),
        onIntent = {}
    )
}
