package com.miltent.featurecardbase.ui.compwrapperfunctions

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.miltent.designsystem.formatter.StatisticTypeFormatter
import com.miltent.designsystem.statistics.StatisticModifierTile
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Attributes
import com.miltent.domain.model.StatisticType

internal fun savingThrowTile(
    type: StatisticType,
    attribute: Attribute,
    proficiency: Boolean, proficiencyBonus: Int
) : @Composable () -> Unit {
    return {
        StatisticModifierTile(
        typeText = stringResource(StatisticTypeFormatter.formatStatisticTypeToFullName(type) ),
        modifierValue = attribute.calculateModifier() + if(proficiency) proficiencyBonus else 0
    )
    }
}
internal fun savingThrowTile(
    type: StatisticType,
    attributes: Attributes,
    savingThrowProficiencies: Pair<StatisticType, StatisticType>,
    proficiencyBonus: Int
): @Composable () -> Unit {
    return savingThrowTile(
        type = type,
        attribute = attributes.values.getValue(type),
        proficiency = type in savingThrowProficiencies.toList(),
        proficiencyBonus = proficiencyBonus
    )
}