package com.miltent.featurecardbase.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.miltent.designsystem.formatter.StatisticTypeFormatter
import com.miltent.designsystem.statistics.StatisticWithModifierTile
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Attributes
import com.miltent.domain.model.StatisticType

@Composable
fun AttributeTiles(attributes: Attributes, modifier: Modifier = Modifier){
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(modifier = Modifier.weight(1f)) {
            AttributeTile(type= StatisticType.STR, attributes)
            AttributeTile(type= StatisticType.INT, attributes)
        }
        Column(modifier = Modifier.weight(1f)) {
            AttributeTile(type= StatisticType.DEX, attributes)
            AttributeTile(type= StatisticType.WIS, attributes)
        }
        Column(modifier = Modifier.weight(1f)) {
            AttributeTile(type = StatisticType.CON, attributes)
            AttributeTile(type = StatisticType.CHA, attributes)
        }
    }
}

@Composable
fun AttributeTile(type: StatisticType, attributes: Attributes) {
    AttributeTile(type = type, attribute = attributes.values.getValue(type))
}

@Composable
fun AttributeTile(type: StatisticType, attribute: Attribute) {
    StatisticWithModifierTile(
        typeText = stringResource(StatisticTypeFormatter.formatStatisticTypeToFullName(type)),
        modifierValue = attribute.calculateModifier(),
        attributeValue = attribute.value
    )
}

@Composable
@Preview(showBackground = true)
fun AttributeTilesPreview(){
    AttributeTiles(Attributes(15))
}

@Preview(showBackground = true)
@Composable
fun AttributeTilePreview() {
    AttributeTile(type = StatisticType.DEX, Attribute(12))
}