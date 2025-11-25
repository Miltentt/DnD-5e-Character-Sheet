package com.miltent.featurecardbase.characterCard.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.miltent.domain.model.Character
import com.miltent.featurecardbase.characterCard.state.CharacterCardViewState
import com.miltent.featurecardbase.ui.composables.AttributeTiles
import com.miltent.featurecardbase.ui.composables.SavingThrowTiles


@Composable
internal fun CharacterCardScreen(){

    val viewModel: CharacterCardViewModel = hiltViewModel()
    val viewState: CharacterCardViewState by viewModel.viewState.collectAsStateWithLifecycle()
    val character = viewState.character ?: throw Exception("character cannot be null")
    CharacterCardScreen(character)
}


@Composable
internal fun CharacterCardScreen(
    character: Character,
){

    Column {
        AttributeTiles(attributes = character.baseAttributes)
        SavingThrowTiles(
            character.baseAttributes,
            savingThrowProficiencies = character.characterClass.savingThrows
        )
    }
}
@Preview(showBackground = true)
@Composable
fun CharacterCardScreenPreview(){
    CharacterCardScreen(Character.dummyCharacter)
}