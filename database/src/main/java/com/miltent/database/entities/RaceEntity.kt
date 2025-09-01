package com.miltent.database.entities

import androidx.room.Entity

@Entity
data class RaceEntity(
    val extraModifierStrength: Int,
    val extraModifierDex: Int,
    val extraModifierCon: Int,
    val extraModifierInt: Int,
    val extraModifierWis: Int,
    val extraModifierCha: Int,
    val specialAbility: List<SpecialAbilityEntity>?,
    val movementSpeed: MovementSpeedEntity
)
