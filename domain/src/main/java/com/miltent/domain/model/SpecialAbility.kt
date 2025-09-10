package com.miltent.domain.model

data class SpecialAbility(
    val id: String,
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
) {
    // TODO pomyśleć nad sposobem przeniesienia wszystkich stringów do strings.xml
    companion object {
        val defaultFighterFightingStyles = listOf(
            SpecialAbility(
                id = "FSDefense",
                name = "Defense",
                description = "While you are wearing armor, you gain a +1 bonus to AC.",
                armorClassModifier = ArmorClass(1)
            ),
            SpecialAbility(
                id = "FSGWF",
                name = "Great Weapon Fighting",
                description = "When you roll a 1 or 2 on a damage die for an attack you make with a melee weapon that you are wielding with two hands, you can reroll the die and must use the new roll, even if the new roll is a 1 or a 2. The weapon must have the two-handed or versatile property for you to gain this benefit.",
            ),
            SpecialAbility(
                id = "FSTWF",
                name = "Two-Weapon Fighting",
                description = "When you engage in two-weapon fighting, you can add your ability modifier to the damage of the second attack.",
            ),
        )
    }
}