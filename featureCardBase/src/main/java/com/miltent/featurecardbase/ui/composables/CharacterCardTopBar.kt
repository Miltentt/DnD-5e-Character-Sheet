package com.miltent.featurecardbase.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.miltent.designsystem.theme.Spacing
import com.miltent.domain.model.Character
import com.miltent.domain.model.HealthPoints
import com.miltent.domain.model.MockCharacter
import com.miltent.resources.R as ResR

@Composable
fun CharacterCardTopBar(modifier: Modifier = Modifier, name: String, condition: String, healthPoints: HealthPoints) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(vertical = Spacing.spacing4)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(ResR.string.condition), fontSize = 10.sp, fontWeight = FontWeight.Bold)
            Text(
                text = condition,
                modifier = Modifier
                    .padding(horizontal = Spacing.spacing12),
                fontSize = 24.sp,
            )
        }

        Text(
            text = name,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(2f)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(ResR.string.hit_points), fontSize = 10.sp, fontWeight = FontWeight.Bold)
            Text(
                text = "${healthPoints.current}/${healthPoints.max}",
                modifier = Modifier
                    .padding(horizontal = Spacing.spacing8),
                fontSize = 24.sp,
            )
        }
    }
}

@Preview
@Composable
fun CharacterCardTopBarPreview() {
    CharacterCardTopBar(name = MockCharacter.value.name,healthPoints = MockCharacter.value.healthPoints, condition = "WELL")

}