package com.miltent.featurecardbase.ui.composables

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miltent.domain.model.Attributes
import com.miltent.domain.model.StatisticType

@Composable
fun SavingThrowTiles(
    attributes: Attributes,
    savingThrowProficiencies: Pair<StatisticType, StatisticType>,
    proficiencyBonus: Int,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Spacer(modifier = Modifier.padding(2.dp))
        Text("Saving Throws", fontSize = 20.sp, modifier = Modifier.padding(horizontal = 16.dp))
        Row {
            Column(modifier = Modifier.weight(1f)) {
                SavingThrowTile(StatisticType.STR, attributes, savingThrowProficiencies, proficiencyBonus)
                SavingThrowTile(StatisticType.DEX, attributes, savingThrowProficiencies, proficiencyBonus)
                SavingThrowTile(StatisticType.CON, attributes, savingThrowProficiencies, proficiencyBonus)
            }
            Column(modifier = Modifier.weight(1f)) {
                SavingThrowTile(StatisticType.INT, attributes, savingThrowProficiencies, proficiencyBonus)
                SavingThrowTile(StatisticType.WIS, attributes, savingThrowProficiencies, proficiencyBonus)
                SavingThrowTile(StatisticType.CHA, attributes, savingThrowProficiencies, proficiencyBonus)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SavingThrowTilesPreview(){
    SavingThrowTiles(Attributes(), Pair(StatisticType.STR, StatisticType.INT), 2)
}