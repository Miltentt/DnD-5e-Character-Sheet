package com.miltent.domain.model

sealed class CharacterClass(
    open val level: Int,
    val identifier: String,
    val movementSpeedModifier: MovementSpeed,
    val skillPoints: Int,
) {

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
}