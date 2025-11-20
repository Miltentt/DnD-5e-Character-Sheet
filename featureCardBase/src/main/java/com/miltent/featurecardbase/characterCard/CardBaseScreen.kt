package com.miltent.featurecardbase.characterCard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import com.miltent.domain.model.Attributes
import com.miltent.domain.model.StatisticType
import com.miltent.featurecardbase.ui.composables.AttributeTiles
import com.miltent.featurecardbase.ui.composables.SavingThrowTiles


@Composable
internal fun CharacterCardScreen(characterId: String){
    Column {
        AttributeTiles(attributes = Attributes())
        SavingThrowTiles(
            Attributes(),
            savingThrowProficiencies = Pair(StatisticType.STR, StatisticType.DEX)
        )
    }
    Box(modifier = Modifier.
    fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = characterId
        )
    }
}
@Preview(showBackground = true)
@Composable
fun CharacterCardScreenPreview(){
    CharacterCardScreen("Tul")
}