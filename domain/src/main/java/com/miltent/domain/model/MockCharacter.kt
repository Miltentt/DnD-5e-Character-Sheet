package com.miltent.domain.model

object MockCharacter {
    val value = Character(
        name = "Mock",
        level = 1,
        race = Race.Dwarf,
        characterClass = CharacterClass.Fighter(1),
        baseAttributes = Attributes()
            .updateAttribute(StatisticType.STR, Attribute(Attribute.baseValueRange.last))
            .updateAttribute(StatisticType.DEX, Attribute(Attribute.baseValueRange.first)),
        temporaryAttributes = Attributes(Attribute.BASE_MODIFIER_VALUE),
        movementSpeed = MovementSpeed(MovementSpeed.BASE_MOVEMENT_SPEED),
        healthPoints = HealthPoints(50)
    )
}