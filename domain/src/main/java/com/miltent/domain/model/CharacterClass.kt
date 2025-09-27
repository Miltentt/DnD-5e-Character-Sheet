package com.miltent.domain.model

sealed class CharacterClass(
    open val level: Int,
    val identifier: String,
    val movementSpeedModifier: MovementSpeed,
    val skillPoints: Int,
) {
    companion object{
        val subClasses = listOf(
            Fighter(0),
            Ranger(0),
        )
        // widziałem że da się przy użyciu reflection używać sealedSublasses ale
        // podobno reflection jest jakieś wolniejsze i trudniejsze dla systemu

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
            skillPoints = 2
        ){

        companion object {
            const val identifier = "Ranger"
        }
            }
}