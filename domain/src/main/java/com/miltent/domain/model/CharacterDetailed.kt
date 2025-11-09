package com.miltent.domain.model

data class CharacterDetailed(
    override val name: String,
    override val level: Int,
    override val race: Race,
    override val characterClass: CharacterClass,
    val baseAttributes: Attributes,
    val temporaryModifiers: Attributes,
    val movementSpeed: MovementSpeed,
    val skills: List<Skill>,
    val specialAbilities: List<SpecialAbility>
): DashboardCharacter