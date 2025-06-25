package com.miltent.domain.model

data class Character(
    override val name: String,
    override val level: Int,
    override val race: Race,
    val baseStrength: Int,
    val baseDexterity: Int,
    val baseConstitution: Int,
    val baseIntelligence: Int,
    val baseWisdom: Int,
    val baseCharisma: Int,
): DashboardCharacter
