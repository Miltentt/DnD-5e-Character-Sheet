package com.miltent.domain.model

data class Skill(val id: Int, val name: String, val statisticType: StatisticType) {

    companion object {
        val defaultSkillList = listOf<Skill>(
            Skill(1, "Acrobatics", StatisticType.DEX),
            Skill(2, "Animal Handling", StatisticType.WIS),
            Skill(3, "Arcana", StatisticType.INT),
            Skill(4, "Athletics", StatisticType.STR),
            Skill(5, "Deception", StatisticType.CHA),
            Skill(6, "History", StatisticType.INT),
            Skill(7, "Insight", StatisticType.WIS),
            Skill(8, "Intimidation", StatisticType.CHA),
            Skill(9, "Investigation", StatisticType.INT),
            Skill(10, "Medicine", StatisticType.WIS),
            Skill(11, "Nature", StatisticType.INT),
            Skill(12, "Perception", StatisticType.WIS),
            Skill(13, "Performance", StatisticType.CHA),
            Skill(14, "Persuasion", StatisticType.CHA),
            Skill(15, "Religion", StatisticType.INT),
            Skill(16, "Sleight of Hand", StatisticType.DEX),
            Skill(17, "Stealth", StatisticType.DEX),
            Skill(18, "Survival", StatisticType.WIS)
        )
    }
}