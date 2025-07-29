package com.miltent.domain.model

data class SpecialAbility(
    val description: String,
    val strengthModifier: Attribute,
    val dexterityModifier: Attribute,
    val charismaModifier: Attribute,
    val constitutionModifier: Attribute,
    val intelligenceModifier: Attribute,
    val wisdomModifier: Attribute,
    val movementSpeedModifier: MovementSpeed,
    val armorClassModifier: ArmorClass
)