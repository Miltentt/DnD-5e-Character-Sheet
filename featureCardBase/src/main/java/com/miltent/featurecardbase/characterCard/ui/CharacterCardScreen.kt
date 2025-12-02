package com.miltent.featurecardbase.characterCard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.miltent.domain.model.Character
import com.miltent.domain.model.HealthPoints
import com.miltent.domain.model.MockCharacter
import com.miltent.featurecardbase.characterCard.state.CharacterCardViewState
import com.miltent.featurecardbase.ui.composables.AttributeTiles
import com.miltent.featurecardbase.ui.composables.CharacterCardTopBar
import com.miltent.featurecardbase.ui.composables.SavingThrowTiles
import com.miltent.featurecardbase.ui.composables.StatisticTiles

private const val EMPTY_TEXT = "-"
@Composable
internal fun CharacterCardScreen(){

    val viewModel: CharacterCardViewModel = hiltViewModel()
    val viewState: CharacterCardViewState by viewModel.viewState.collectAsStateWithLifecycle()
    val character = viewState.character
    if (character != null) {
        CharacterCardScreen(character)
    } else{
        EmptyCharacterCardScreen()
    }
}
@Composable
internal fun EmptyCharacterCardScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CharacterCardTopBar(
            modifier = Modifier,
            name = EMPTY_TEXT,
            healthPoints = HealthPoints(0),
            condition = EMPTY_TEXT
        )
    }
}

@Composable
internal fun CharacterCardScreen(
    character: Character,
){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        CharacterCardTopBar(
            modifier = Modifier.weight(0.7f),
            name = character.name,
            healthPoints = character.healthPoints,
            condition = "WELL"
            )
        StatisticTiles(character, modifier = Modifier.weight(1f))
        AttributeTiles(
            attributes = character.baseAttributes,
            modifier = Modifier.weight(3f))
        SavingThrowTiles(
            attributes = character.baseAttributes,
            savingThrowProficiencies = character.characterClass.savingThrows,
            character.proficiencyBonus,
            modifier = Modifier.weight(2f)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun CharacterCardScreenPreview(){
    CharacterCardScreen(MockCharacter.value)
}
@Preview(showBackground = true)
@Composable
fun EmptyCharacterCardScreenPreview(){
    EmptyCharacterCardScreen()
}
