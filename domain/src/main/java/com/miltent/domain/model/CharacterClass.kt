package com.miltent.domain.model

sealed class CharacterClass(
    open val level: Int,
    val identifier: String,
    val movementSpeedModifier: MovementSpeed,
    val skillPoints: Int,
    val hitDie: Int,
    val savingThrows: Pair<StatisticType, StatisticType>
) {
    companion object {

        fun createCharacterClass(
            level: Int,
            classIdentifier: String
        ): CharacterClass {
            return when (classIdentifier) {
                Fighter.identifier -> CharacterClass.Fighter(level)
                Ranger.identifier -> CharacterClass.Ranger(level)
                else -> throw IllegalArgumentException("Unknown character class: $classIdentifier")
            }
        }

    }

    data class Fighter(override val level: Int) :
        CharacterClass(
            level = level,
            identifier,
            MovementSpeed(0.0),
            skillPoints = 2,
            hitDie = 10,
            savingThrows = Pair(StatisticType.STR, StatisticType.CON)
        ) {
        companion object {
            const val identifier = "Fighter"
        }
    }

    data class Ranger(override val level: Int) :
        CharacterClass(
            level = level,
            identifier,
            MovementSpeed(0.0),
            skillPoints = 2,
            hitDie = 10,
            savingThrows = Pair(StatisticType.STR, StatisticType.DEX)
        ) {
        companion object {
            const val identifier = "Ranger"
        }
    }
}
