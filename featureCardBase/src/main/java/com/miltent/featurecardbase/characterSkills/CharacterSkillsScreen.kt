package com.miltent.featurecardbase.characterSkills

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun CharacterSkillsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Skills"
        )
    }
}
@Preview(showBackground = true)
@Composable
fun CharacterSkillsScreenPreview(){
    CharacterSkillsScreen()
}