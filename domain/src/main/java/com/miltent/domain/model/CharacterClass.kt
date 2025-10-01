package com.miltent.domain.model

sealed class CharacterClass(
    open val level: Int,
    val identifier: String,
    val movementSpeedModifier: MovementSpeed,
    val skillPoints: Int,
    val hitDie: Int
) {

    data class Fighter(override val level: Int) :
        CharacterClass(
            level = level,
            identifier,
            MovementSpeed(0.0),
            skillPoints = 2,
            hitDie = 10
        ) {
            companion object {
                const val identifier = "Fighter"
            }
        }
}