package com.miltent.domain.model

sealed class Race(val extraModifierStrength: Int, specialAbility: SpecialAbility?) {

    data object Dwarf: Race(2, null)
}