package com.miltent.domain.model

sealed class CharacterClass(
    open val level: Int,
    val name: String,
    val movementSpeedModifier: MovementSpeed
) {

    data class Fighter(override val level: Int) :
        CharacterClass(
            level = level,
            name,
            MovementSpeed(0.0)
        ) {
            companion object {
                const val name = "Fighter"
            }
        }
}