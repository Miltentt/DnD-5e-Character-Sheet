package com.miltent.domain.model

sealed class Race(
    val extraModifierStrength: Int,
    val extraModifierDex: Int,
    val extraModifierCon: Int,
    val extraModifierInt: Int,
    val extraModifierWis: Int,
    val extraModifierCha: Int,
    val specialAbility: List<SpecialAbility>?,
    val movementSpeed: MovementSpeed
) {

    data object Dwarf : Race(
        extraModifierStrength = 2,
        extraModifierDex = 0,
        extraModifierCon = 0,
        extraModifierInt = 0,
        extraModifierWis = 0,
        extraModifierCha = 0,
        specialAbility = null,
        movementSpeed = MovementSpeed(7.5)
    )
}