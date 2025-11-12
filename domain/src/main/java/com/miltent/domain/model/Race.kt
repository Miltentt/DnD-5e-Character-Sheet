package com.miltent.domain.model

enum class Race(
    val identifier: String,
    val extraModifiers: Attributes,
    val specialAbility: List<SpecialAbility>?,
    val skillPoints: Int,
    val movementSpeed: MovementSpeed
) {
    Dwarf(
        identifier = "Dwarf",
        extraModifiers = Attributes(Attribute.BASE_MODIFIER_VALUE)
            .addToAttribute(StatisticType.STR, Attribute(2))
            .addToAttribute(StatisticType.CON, Attribute(2)),
        specialAbility = null,
        skillPoints= 2,
        movementSpeed = MovementSpeed(7.5)
    ),
    Drow(
        identifier = "Drow",
        extraModifiers = Attributes(Attribute.BASE_MODIFIER_VALUE)
            .addToAttribute(StatisticType.DEX, Attribute(2))
            .addToAttribute(StatisticType.CHA, Attribute(1)),
        specialAbility = null,
        skillPoints= 2,
        movementSpeed = MovementSpeed(9.0)
    )
}