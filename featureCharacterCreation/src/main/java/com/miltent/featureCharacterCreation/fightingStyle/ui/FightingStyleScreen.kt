package com.miltent.featureCharacterCreation.fightingStyle.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.DNDSheetTheme

@Composable
fun FightingStyleScreen() {
    val viewModel: FightingStyleViewModel = hiltViewModel()
    DNDSheetTheme {
        Scaffold(
            modifier = Modifier.background(Colors.primary),
            bottomBar = {

            },
            content = { paddingValues: PaddingValues ->
                Column {
                    RadioButton(
                        selected = false,
                        onClick = { /*TODO*/ }
                    )
                }
            }
        )
    }
}

@Composable
@Preview
fun FightingStyleScreenPreview() {
    FightingStyleScreen()
}
