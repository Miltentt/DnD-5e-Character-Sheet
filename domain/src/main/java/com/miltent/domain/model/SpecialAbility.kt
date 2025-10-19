package com.miltent.domain.model

data class SpecialAbility(
    val id: String,
    val type: SpecialAbilityType,
    val name: String,
    val description: String,
    val strengthModifier: Attribute = Attribute(0),
    val dexterityModifier: Attribute = Attribute(0),
    val charismaModifier: Attribute = Attribute(0),
    val constitutionModifier: Attribute = Attribute(0),
    val intelligenceModifier: Attribute = Attribute(0),
    val wisdomModifier: Attribute = Attribute(0),
    val movementSpeedModifier: MovementSpeed = MovementSpeed(0.0),
    val armorClassModifier: ArmorClass = ArmorClass(0)
)