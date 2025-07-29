package com.miltent.domain.model

sealed class CharacterClass(
    val name: String,
    val characterCreationProgression: List<CharacterProgression>,
    val movementSpeedModifier: MovementSpeed
) {

    data object Fighter :
        CharacterClass(
            "Fighter",
            listOf(CharacterProgression.FightingStyle),
            MovementSpeed(0.0)
        )
}