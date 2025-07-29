package com.miltent.domain.model

sealed class Race(val extraModifierStrength: Int, specialAbility: SpecialAbility?,val movementSpeed: MovementSpeed, val characterCreationProgression: List<CharacterProgression>) {

    data object Dwarf: Race(2, null, MovementSpeed(7.5), characterCreationProgression = emptyList())
}