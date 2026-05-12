package com.miltent.featurecardbase.characterSkills.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.miltent.domain.model.SkillWithModifier
import com.miltent.featurecardbase.characterSkills.ui.composables.SkillTile

@Composable
fun CharacterSkillsScreen() {
    val viewModel: CharacterSkillsViewModel = hiltViewModel()
    val viewState = viewModel.viewState.collectAsStateWithLifecycle()
    val skills = viewState.value.skills
    CharacterSkillsScreen(skills)
}

@Composable
fun CharacterSkillsScreen(skills: List<SkillWithModifier>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SKILLS",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = Modifier.padding(vertical = 22.dp)
        )

        LazyColumn() {
            items(
                items = skills, key = { it.id }) { skill ->
                SkillTile(skill.name, skill.modifier)
            }
        }
    }
}

@Preview
@Composable
fun CharacterSkillsScreenPreview() {
    CharacterSkillsScreen(
        skills = listOf(
            SkillWithModifier(0, "Skill1", 2),
            SkillWithModifier(1, "Superskill2", 8),
            SkillWithModifier(2, "Megaskill3", -2),
        )
    )
}