package com.miltent.database.entities

import androidx.annotation.Keep

@Keep
data class SpecialAbilityEntity(
    val id: String,
    val name: String,
    val description: String,
    val strengthModifier: Int,
    val dexterityModifier: Int,
    val charismaModifier: Int,
    val constitutionModifier: Int,
    val intelligenceModifier: Int,
    val wisdomModifier: Int,
    val movementSpeedModifier: Double,
    val armorClassModifier: Int
)
