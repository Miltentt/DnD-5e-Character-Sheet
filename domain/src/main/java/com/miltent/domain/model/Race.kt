package com.miltent.domain.model

enum class Race(
    val identifier: String,
    val extraModifierStrength: Attribute,
    val extraModifierDex: Attribute,
    val extraModifierCon: Attribute,
    val extraModifierInt: Attribute,
    val extraModifierWis: Attribute,
    val extraModifierCha: Attribute,
    val specialAbility: List<SpecialAbility>?,
    val skillPoints: Int,
    val movementSpeed: MovementSpeed
) {
    Dwarf(
        identifier = "Dwarf",
        extraModifierStrength = Attribute(2),
        extraModifierDex = Attribute(0),
        extraModifierCon = Attribute(2),
        extraModifierInt = Attribute(0),
        extraModifierWis = Attribute(0),
        extraModifierCha = Attribute(0),
        specialAbility = null,
        skillPoints= 2,
        movementSpeed = MovementSpeed(7.5)
    ),
    Drow(
        identifier = "Drow",
        extraModifierStrength = Attribute(0),
        extraModifierDex = Attribute(2),
        extraModifierCon = Attribute(0),
        extraModifierInt = Attribute(0),
        extraModifierWis = Attribute(0),
        extraModifierCha = Attribute(1),
        specialAbility = null,
        skillPoints= 2,
        movementSpeed = MovementSpeed(9.0)
    )
}