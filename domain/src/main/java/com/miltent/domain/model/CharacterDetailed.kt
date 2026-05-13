package com.miltent.domain.model

data class CharacterDetailed(
    val character: Character,
    val skills: List<SkillWithModifier>,
    val specialAbilities: List<SpecialAbility>
)