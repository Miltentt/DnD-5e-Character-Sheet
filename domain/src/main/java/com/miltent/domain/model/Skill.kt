package com.miltent.domain.model

data class Skill(val id: Int, val name: String, val modificator: String) {

    companion object {
        val defaultSkillList = listOf<Skill>(
            Skill(1, "Acrobatics", "DEX"),
            Skill(2, "Animal Handling", "WIS"),
            Skill(3, "Arcana", "INT"),
            Skill(4, "Athletics", "STR"),
            Skill(5, "Deception", "CHA"),
            Skill(6, "History", "INT"),
            Skill(7, "Insight", "WIS"),
            Skill(8, "Intimidation", "CHA"),
            Skill(9, "Investigation", "INT"),
            Skill(10, "Medicine", "WIS"),
            Skill(11, "Nature", "INT"),
            Skill(12, "Perception", "WIS"),
            Skill(13, "Performance", "CHA"),
            Skill(14, "Persuasion", "CHA"),
            Skill(15, "Religion", "INT"),
            Skill(16, "Sleight of Hand", "DEX"),
            Skill(17, "Stealth", "DEX"),
            Skill(18, "Survival", "WIS")
        )
    }
}