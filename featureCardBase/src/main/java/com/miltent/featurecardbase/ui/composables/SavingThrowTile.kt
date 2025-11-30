package com.miltent.featurecardbase.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.miltent.designsystem.formatter.StatisticTypeFormatter
import com.miltent.designsystem.statistics.StatisticModifierTile
import com.miltent.designsystem.theme.Spacing
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Attributes
import com.miltent.domain.model.StatisticType
import com.miltent.resources.R as ResR

@Composable
fun SavingThrowTiles(
    attributes: Attributes,
    savingThrowProficiencies: Pair<StatisticType, StatisticType>,
    proficiencyBonus: Int,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Spacer(modifier = Modifier.padding(Spacing.spacing2))
        Text(
            text = stringResource(ResR.string.saving_throws),
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = Spacing.spacing16)
        )
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

@Composable
fun SavingThrowTile(
    type: StatisticType,
    attributes: Attributes,
    savingThrowProficiencies: Pair<StatisticType, StatisticType>,
    proficiencyBonus: Int
){
    SavingThrowTile(
        type = type,
        attribute = attributes.values.getValue(type),
        proficiency = type in savingThrowProficiencies.toList(),
        proficiencyBonus = proficiencyBonus
    )
}
@Composable
fun SavingThrowTile(type: StatisticType, attribute: Attribute, proficiency: Boolean, proficiencyBonus: Int) {
    StatisticModifierTile(
        typeText = stringResource(StatisticTypeFormatter.formatStatisticTypeToFullName(type) ),
        modifierValue = attribute.calculateModifier() + if(proficiency) proficiencyBonus else 0
    )
}

@Preview(showBackground = true)@Composable
fun SavingThrowTilesPreview(){
    SavingThrowTiles(
        Attributes(),
        Pair(StatisticType.STR, StatisticType.INT),
        2)
}

@Preview(showBackground = true)
@Composable
fun SavingThrowTilePreview(){
    SavingThrowTile(StatisticType.INT, Attribute(14),true, 2)
}