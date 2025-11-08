package com.miltent.domain.model

enum class Race(
    val identifier: String,
    val extraModifiers: Attributes,
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
        extraModifiers = Attributes(0)
            .addToAttribute(StatisticType.STR, Attribute(2))
            .addToAttribute(StatisticType.CON, Attribute(2)),
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
        extraModifiers = Attributes(0)
            .addToAttribute(StatisticType.DEX, Attribute(2))
            .addToAttribute(StatisticType.CHA, Attribute(1)),
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