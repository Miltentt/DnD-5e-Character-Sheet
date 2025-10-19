package com.miltent.domain.model

enum class StatisticType(val value: String) {
    STR("STR"),
    DEX("DEX"),
    INT("INT"),
    WIS("WIS"),
    CON("CON"),
    CHA("CHA");

    companion object {
        fun getStatisticType(value: String): StatisticType = StatisticType.entries.find {
            it.value == value
        } ?: throw IllegalArgumentException("Invalid StatisticType value: $value")
    }
}