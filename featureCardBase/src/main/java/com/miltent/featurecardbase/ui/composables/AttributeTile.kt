package com.miltent.featurecardbase.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.miltent.designsystem.formatter.StatisticTypeFormatter
import com.miltent.designsystem.statistics.StatisticWithModifierTile
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Attributes
import com.miltent.domain.model.StatisticType

@Composable
fun AttributeTile(type: StatisticType, attributes: Attributes) {
    AttributeTile(type = type, attribute = attributes.values.getValue(type))
}

@Composable
fun AttributeTile(type: StatisticType, attribute: Attribute) {
    StatisticWithModifierTile(
        typeText = stringResource(StatisticTypeFormatter.formatStatisticTypeLong(type)),
        modifierValue = attribute.calculateModifier(),
        attributeValue = attribute.value
    )
}

@Preview(showBackground = true)
@Composable
fun AttributeTilePreview() {
    AttributeTile(type = StatisticType.DEX, Attribute(12))
}