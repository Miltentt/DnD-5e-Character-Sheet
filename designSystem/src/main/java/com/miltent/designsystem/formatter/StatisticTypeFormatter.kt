package com.miltent.designsystem.formatter

import com.miltent.domain.model.StatisticType
import com.miltent.resources.R as ResR

object StatisticTypeFormatter {
    fun formatStatisticTypeShort(statisticType: StatisticType): Int {
        return when (statisticType) {
            StatisticType.STR -> ResR.string.statistic_short_strength
            StatisticType.DEX -> ResR.string.statistic_short_dexterity
            StatisticType.CON -> ResR.string.statistic_short_constitution
            StatisticType.INT -> ResR.string.statistic_short_intelligence
            StatisticType.WIS -> ResR.string.statistic_short_wisdom
            StatisticType.CHA -> ResR.string.statistic_short_charisma
        }
    }
    fun formatStatisticTypeLong(statisticType: StatisticType): Int {
        return when (statisticType) {
            StatisticType.STR -> ResR.string.statistic_long_strength
            StatisticType.DEX -> ResR.string.statistic_long_dexterity
            StatisticType.CON -> ResR.string.statistic_long_constitution
            StatisticType.INT -> ResR.string.statistic_long_intelligence
            StatisticType.WIS -> ResR.string.statistic_long_wisdom
            StatisticType.CHA -> ResR.string.statistic_long_charisma
        }
    }
}