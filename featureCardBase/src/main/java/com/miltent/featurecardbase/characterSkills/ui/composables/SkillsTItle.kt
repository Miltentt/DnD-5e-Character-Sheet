package com.miltent.featurecardbase.characterSkills.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun SkillsTitle() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
        Text(
            text = "SKILLS",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp)
    }
}