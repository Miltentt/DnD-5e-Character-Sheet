package com.miltent.featuredashboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.miltent.designsystem.buttons.ProgressButton
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.DNDSheetTheme
import com.miltent.designsystem.theme.Spacing
import com.miltent.featuredashboard.event.DashboardEvent
import com.miltent.featuredashboard.state.DashboardViewState
import com.miltent.featuredashboard.ui.composables.CharacterTile
import com.miltent.resources.R as ResR

@Composable
fun DashboardScreen() {
    val viewModel: DashboardViewModel = hiltViewModel()
    val viewState: DashboardViewState = viewModel.viewState.collectAsState().value

    DashboardScreen(viewState = viewState, onEvent = viewModel::setEvent)
}

@Composable
private fun DashboardScreen(viewState: DashboardViewState.Loaded, onEvent: (DashboardEvent) -> Unit) {
    DNDSheetTheme {
        Scaffold(
            modifier = Modifier.background(Colors.primary),
            bottomBar = {
                ProgressButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = Spacing.extraSmall,
                            bottom = Spacing.medium,
                            end = Spacing.extraSmall
                        ), buttonText = stringResource(ResR.string.button_create_character),
                    onClick = { onEvent.invoke(DashboardEvent.OnCharacterCreateClicked) }
                )
            },
            content = { paddingValues: PaddingValues ->
                LazyColumn(modifier = Modifier
                    .padding(Spacing.extraSmall)
                    .padding(paddingValues)) {
                    item { CharacterTile() }
                }
            }
        )
    }
}

@Composable
@Preview
fun DashboardScreen_Preview() {
    DashboardScreen()
}