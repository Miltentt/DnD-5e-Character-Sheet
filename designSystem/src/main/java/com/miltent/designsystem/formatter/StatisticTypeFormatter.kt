package com.miltent.designsystem.formatter

import com.miltent.domain.model.StatisticType
import com.miltent.resources.R as ResR

object StatisticTypeFormatter {
    fun formatStatisticTypeToShortName(statisticType: StatisticType): Int {
        return when (statisticType) {
            StatisticType.STR -> ResR.string.statistic_short_strength
            StatisticType.DEX -> ResR.string.statistic_short_dexterity
            StatisticType.CON -> ResR.string.statistic_short_constitution
            StatisticType.INT -> ResR.string.statistic_short_intelligence
            StatisticType.WIS -> ResR.string.statistic_short_wisdom
            StatisticType.CHA -> ResR.string.statistic_short_charisma
        }
    }
    fun formatStatisticTypeToFullName(statisticType: StatisticType): Int {
        return when (statisticType) {
            StatisticType.STR -> ResR.string.statistic_full_name_strength
            StatisticType.DEX -> ResR.string.statistic_full_name_dexterity
            StatisticType.CON -> ResR.string.statistic_full_name_constitution
            StatisticType.INT -> ResR.string.statistic_full_name_intelligence
            StatisticType.WIS -> ResR.string.statistic_full_name_wisdom
            StatisticType.CHA -> ResR.string.statistic_full_name_charisma
        }
    }
}