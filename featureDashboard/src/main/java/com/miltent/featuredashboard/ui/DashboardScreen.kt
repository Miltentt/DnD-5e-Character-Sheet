package com.miltent.featuredashboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.miltent.core.compose.ObserveEvents
import com.miltent.designsystem.buttons.ProgressButton
import com.miltent.designsystem.formatter.CharacterClassFormatter
import com.miltent.designsystem.formatter.RaceFormatter
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.DNDSheetTheme
import com.miltent.designsystem.theme.Spacing
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.DashboardCharacter
import com.miltent.domain.model.Race
import com.miltent.featuredashboard.event.DashboardEvent
import com.miltent.featuredashboard.intent.DashboardIntent
import com.miltent.featuredashboard.state.DashboardViewState
import com.miltent.featuredashboard.ui.composables.CharacterTile
import com.miltent.featuredashboard.ui.composables.DeleteCharacterPopUp
import com.miltent.resources.R as ResR

@Composable
internal fun DashboardScreen(onEvent: (DashboardEvent) -> Unit) {
    val viewModel: DashboardViewModel = hiltViewModel()
    val viewState: DashboardViewState = viewModel.viewState.collectAsStateWithLifecycle().value
    ObserveEvents(
        events = viewModel.event,
        onEvent = { onEvent(it) })
        DashboardScreen(viewState = viewState, onIntent = viewModel::setIntent)
}

@Composable
private fun DashboardScreen(
    viewState: DashboardViewState,
    onIntent: (DashboardIntent) -> Unit
) {
    DNDSheetTheme {
        Scaffold(
            modifier = Modifier
                .background(Colors.primary)
                .statusBarsPadding(),
            bottomBar = {
                ProgressButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WindowInsets.navigationBars.asPaddingValues())
                        .padding(
                            start = Spacing.spacing4,
                            bottom = Spacing.spacing16,
                            end = Spacing.spacing4
                        ), buttonText = stringResource(ResR.string.button_create_character),
                    onClick = { onIntent.invoke(DashboardIntent.OnCharacterCreateClicked) }
                )
            },
            content = { paddingValues: PaddingValues ->
                when (viewState) {
                    is DashboardViewState.Loaded -> {
                        var characterLongClicked by remember { mutableStateOf<DashboardCharacter?>(null) }
                        Box(modifier = Modifier.fillMaxSize()){
                            characterLongClicked?.let {
                                Dialog(
                                    onDismissRequest = { characterLongClicked = null },
                                ) {
                                    DeleteCharacterPopUp(
                                        name = characterLongClicked?.name.orEmpty(),
                                        onClick = {
                                            if (it) onIntent.invoke(
                                                DashboardIntent.OnCharacterLongClick(
                                                    id = characterLongClicked?.id.orEmpty()
                                                )
                                            )
                                            characterLongClicked = null
                                        }
                                    )
                                }
                            }
                            LazyColumn(
                                modifier = Modifier
                                    .padding(Spacing.spacing16)
                                    .padding(paddingValues)
                            ) {
                                items(
                                    viewState.characterList,
                                    itemContent = { character: DashboardCharacter ->
                                        CharacterTile(
                                            name = character.name,
                                            race = stringResource(RaceFormatter.formatRace(character.race)),
                                            level = character.level,
                                            characterClass = stringResource(
                                                CharacterClassFormatter.formatCharacterClass(
                                                    character.characterClass::class
                                                )
                                            ),
                                            onClick = {
                                                onIntent.invoke(
                                                    DashboardIntent.OnCharacterClicked(
                                                        characterId = character.id
                                                    )
                                                )
                                            },
                                            onLongClick = { characterLongClicked = character }
                                        )
                                    })
                            }
                        }
                    }
                    is DashboardViewState.Empty ->
                        Text(
                            stringResource(ResR.string.no_characters),
                            color = Colors.primary,
                            fontSize = 22.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(Spacing.spacing16)
                                .background(Colors.onPrimary)
                                .padding(Spacing.spacing8)
                        )
                }

            }
        )
    }
}

@Composable
@Preview
fun DashboardScreenEmpty_Preview() {
    val state = DashboardViewState.Empty
    DashboardScreen(viewState = state, onIntent = {})
}

@Composable
@Preview
fun DashboardScreenLoaded_Preview() {
    val state = DashboardViewState.Loaded(
        listOf(
            object : DashboardCharacter {
                override val id = "Nandor"
                override val name = "Nandor"
                override val level = 5
                override val race = Race.Drow
                override val characterClass = CharacterClass.Ranger(5)
            },
        )
    )
    DashboardScreen(viewState = state, onIntent = {})
}

