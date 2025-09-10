package com.miltent.designsystem.skills

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miltent.designsystem.theme.Colors
import com.miltent.designsystem.theme.Spacing

@Composable
fun Skill(modifier: Modifier = Modifier, modificator: String, name: String, value: String) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.width(IntrinsicSize.Max),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacing12)
        ) {
            Text(text = modificator, modifier = Modifier.padding(end = Spacing.spacing16))
            Text(text = name, modifier.align(Alignment.CenterVertically))
            Text(
                text = value,
                modifier
                    .border(1.dp, Colors.primary, CutCornerShape(0))
                    .padding(Spacing.spacing4)
            )
        }
        HorizontalDivider(modifier = Modifier.wrapContentWidth())
    }
}

@Composable
@Preview
fun SkillPreview() {
    Skill(
        modificator = "DEX",
        name = "Acrobatics",
        value = "+2"
    )
}