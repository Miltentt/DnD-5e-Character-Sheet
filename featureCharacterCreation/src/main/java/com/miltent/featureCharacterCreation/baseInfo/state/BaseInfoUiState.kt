package com.miltent.featureCharacterCreation.baseInfo.state

import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race

data class BaseInfoUiState(
    val name: String,
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,
    val race: Race?,
    val characterClass: CharacterClass?
)