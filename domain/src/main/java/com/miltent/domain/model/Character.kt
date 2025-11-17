package com.miltent.domain.model

import java.util.UUID

data class Character(
    override val id: String = UUID.randomUUID().toString(),
    override val name: String,
    override val level: Int,
    override val race: Race,
    override val characterClass: CharacterClass,
    val baseAttributes: Attributes,
    val temporaryAttributes: Attributes,
    val movementSpeed: MovementSpeed,
    val healthPoints: HealthPoints
): DashboardCharacter {

    interface Builder1stLevel {

        val baseAttributes: Attributes
        val race: Race
        val characterClass: CharacterClass
        val skillsIds: List<Int>
        val specialAbility: List<SpecialAbility>

        fun baseInfo(
            name: String,
            race: Race,
            characterClass: CharacterClass,
            baseAttributes: Attributes
        )

        fun skills(skillsIds: List<Int>)

        fun specialAbility(vararg specialAbility: SpecialAbility)

        fun build(): Character
    }
}
