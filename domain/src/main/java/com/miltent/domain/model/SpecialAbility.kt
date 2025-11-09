package com.miltent.domain.model

data class SpecialAbility(
    val id: String,
    val type: SpecialAbilityType,
    val name: String,
    val description: String,
    val attributeModifiers: Attributes = Attributes(0),
    val movementSpeedModifier: MovementSpeed = MovementSpeed(0.0),
    val armorClassModifier: ArmorClass = ArmorClass(0)
)