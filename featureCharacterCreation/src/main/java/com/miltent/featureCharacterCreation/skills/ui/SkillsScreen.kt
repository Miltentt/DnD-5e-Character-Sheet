package com.miltent.featureCharacterCreation.skills.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
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
import com.miltent.designsystem.skills.SelectableSkill
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.DNDSheetTheme
import com.miltent.designsystem.theme.Spacing
import com.miltent.domain.model.Skill
import com.miltent.featureCharacterCreation.skills.event.SkillsEvent
import com.miltent.featureCharacterCreation.skills.intent.SkillsIntent
import com.miltent.featureCharacterCreation.skills.state.SkillsUiState
import com.miltent.featureCharacterCreation.skills.state.SkillsViewState
import com.miltent.resources.R as ResR

@Composable
fun SkillsScreen(onEvent: (SkillsEvent) -> Unit) {
    val viewModel: SkillsViewModel = hiltViewModel()
    val viewState: SkillsViewState = viewModel.viewState.collectAsStateWithLifecycle().value
    ObserveEvents(events = viewModel.event, onEvent = { onEvent(it) })
    SkillsScreen(viewState = viewState, onIntent = viewModel::setIntent)
}

@Composable
private fun SkillsScreen(viewState: SkillsViewState, onIntent: (SkillsIntent) -> Unit) {
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
                        .windowInsetsPadding(WindowInsets.navigationBars),
                    buttonText = stringResource(ResR.string.common_button_next),
                    onClick = { onIntent.invoke(SkillsIntent.OnNextClicked) }
                )
            },
            content = { paddingValues: PaddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    viewState.skillList.forEach { skill: Skill ->
                        SelectableSkill(
                            isChecked = false,
                            onCheckedChange = {
                                onIntent.invoke(
                                    SkillsIntent.OnSkillToggled(
                                        skill.id,
                                        it
                                    )
                                )
                            },
                            modificator = skill.modificator,
                            name = skill.name,
                            value = "+2"
                        )
                    }
                }
            }
        )
    }
}


@Composable
@Preview
fun SkillsScreenPreview() {
    SkillsScreen(
        viewState = SkillsViewState(
            SkillsUiState(), listOf(
                Skill(1, "Acrobatics", "DEX"),
                Skill(2, "Animal Handling", "WIS"),
                Skill(3, "Arcana", "INT"),
                Skill(4, "Athletics", "STR"),
            )
        ), onIntent = {}
    )
}
