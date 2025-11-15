package com.miltent.domain.model

enum class LanguageSuffix(val value: String) {
    PL("pl"),
    EN("en");

    companion object {
        fun getLanguageSuffix(value: String): StatisticType = StatisticType.entries.find {
            it.value == value
        } ?: throw IllegalArgumentException("Invalid LanguageSuffix value: $value")
    }
}