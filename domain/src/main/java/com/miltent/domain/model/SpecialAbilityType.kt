package com.miltent.domain.model

enum class SpecialAbilityType(val value: String) {
    Feat("Feat"),
    FightingStyle("FightingStyle"),
    ClassSpecific("ClassSpecific"),
    Racial("Racial");

    companion object {
        fun getSpecialAbilityType(value: String): SpecialAbilityType = SpecialAbilityType.entries.find {
            it.value == value
        } ?: throw IllegalArgumentException("Invalid StatisticType value: $value")
    }
}