package com.miltent.featurecardbase.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.miltent.domain.model.Attributes
import com.miltent.domain.model.StatisticType

@Composable
fun SavingThrowTiles(attributes: Attributes, savingThrowProficiencies: Pair<StatisticType, StatisticType>) {

    Row {
        Column(modifier = Modifier.weight(1f)) {
            SavingThrowTile(StatisticType.STR, attributes, savingThrowProficiencies)
            SavingThrowTile(StatisticType.DEX, attributes, savingThrowProficiencies)
            SavingThrowTile(StatisticType.CON, attributes, savingThrowProficiencies)
        }
        Column(modifier = Modifier.weight(1f)) {
            SavingThrowTile(StatisticType.INT, attributes, savingThrowProficiencies)
            SavingThrowTile(StatisticType.WIS, attributes, savingThrowProficiencies)
            SavingThrowTile(StatisticType.CHA, attributes, savingThrowProficiencies)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SavingThrowTilesPreview(){
    SavingThrowTiles(Attributes(), Pair(StatisticType.STR, StatisticType.INT))
}