package com.miltent.featurecardbase.characterSkills.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miltent.designsystem.theme.Colors

private val signForInt: (Int) -> String = { "%+d".format(it) }
@Composable
fun SkillTile(skillName: String, skillModifier: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 5.dp)
            .background(color = Colors.onSecondary, shape = RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(16.dp),
                color = Colors.secondary
            )
            .padding(start = 32.dp, end = 16.dp)
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = skillName,
            fontSize = 16.sp,
            color = Colors.primary,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = signForInt(skillModifier),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Colors.primary
        )
    }
}

@Preview
@Composable
fun SkillTilePreview() {
    SkillTile("Skill", 2)
}