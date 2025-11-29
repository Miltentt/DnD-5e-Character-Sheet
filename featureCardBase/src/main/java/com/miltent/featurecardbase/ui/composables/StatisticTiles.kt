package com.miltent.featurecardbase.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miltent.designsystem.statistics.BaseCardStatisticTile
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.Spacing
import com.miltent.domain.model.Character
import com.miltent.resources.R as ResR

@Composable
fun StatisticTiles(character: Character, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(Spacing.spacing8)
            .border(
                shape = RoundedCornerShape(12.dp),
                width = 2.dp,
                color = Colors.primary
            ),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BaseCardStatisticTile(
            stringResource(ResR.string.proficiency_bonus),
            character.proficiencyBonus.toString()
        )
        BaseCardStatisticTile(
            stringResource(ResR.string.walking_speed),
            character.movementSpeed.value.toString()
        )
        BaseCardStatisticTile(
            stringResource(ResR.string.initiative),
            character.baseInitiativeBonus.toString()
        )
        BaseCardStatisticTile(
            stringResource(ResR.string.armor_class),
            character.baseArmorClass.value.toString()
        )
    }

}

@Preview
@Composable
fun StatisticTilesPreview(){
    StatisticTiles(Character.dummyCharacter)
}