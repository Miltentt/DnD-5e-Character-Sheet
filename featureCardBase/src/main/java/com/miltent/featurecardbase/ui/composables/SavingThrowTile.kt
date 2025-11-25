package com.miltent.featurecardbase.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.miltent.designsystem.formatter.StatisticTypeFormatter
import com.miltent.designsystem.statistics.StatisticModifierTile
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Attributes
import com.miltent.domain.model.StatisticType


@Composable
fun SavingThrowTile(type: StatisticType, attributes: Attributes, savingThrowProficiencies: Pair<StatisticType, StatisticType>){
    SavingThrowTile(type,attributes.values.getValue(type), type in savingThrowProficiencies.toList())
}
@Composable
fun SavingThrowTile(type: StatisticType, attribute: Attribute, proficiency: Boolean) {
    StatisticModifierTile(
        typeText = stringResource(StatisticTypeFormatter.formatStatisticTypeLong(type) ),
        modifierValue = attribute.calculateModifier() + if(proficiency) Attribute.PROFICIENCY_MODIFIER_BONUS else 0
    )
}

@Preview(showBackground = true)
@Composable
fun SavingThrowTilePreview(){
    SavingThrowTile(StatisticType.INT, Attribute(14),true)
}