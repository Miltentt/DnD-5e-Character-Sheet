package com.miltent.database.domainToDb

import com.miltent.database.entities.skills.SkillTranslationEntity
import com.miltent.domain.model.LanguageSuffix

class SkillTranslationEntitiesFactory {
    companion object{
        private fun createSkillTranslationEntities(
            languageSuffix: LanguageSuffix,
            acrobatics: String,
            animalHandling: String,
            arcana: String,
            athletics: String,
            deception: String,
            history: String,
            insight: String,
            intimidation: String,
            investigation: String,
            medicine: String,
            nature: String,
            perception: String,
            performance: String,
            persuasion: String,
            religion: String,
            sleightOfHand: String,
            stealth: String,
            survival: String
        ) : List<SkillTranslationEntity> {
            return listOf(
                SkillTranslationEntity("1" + languageSuffix.value, 1, name = acrobatics, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("2" + languageSuffix.value, 2, name = animalHandling, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("3" + languageSuffix.value, 3, name = arcana, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("4" + languageSuffix.value, 4, name = athletics, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("5" + languageSuffix.value, 5, name = deception, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("6" + languageSuffix.value, 6, name = history, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("7" + languageSuffix.value, 7, name = insight, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("8" + languageSuffix.value, 8, name = intimidation, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("9" + languageSuffix.value, 9, name = investigation, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("10" + languageSuffix.value, 10, name = medicine, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("11" + languageSuffix.value, 11, name = nature, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("12" + languageSuffix.value, 12, name = perception, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("13" + languageSuffix.value, 13, name = performance, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("14" + languageSuffix.value, 14, name = persuasion, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("15" + languageSuffix.value, 15, name = religion, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("16" + languageSuffix.value, 16, name = sleightOfHand, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("17" + languageSuffix.value, 17, name = stealth, languageSuffix = languageSuffix.value),
                SkillTranslationEntity("18" + languageSuffix.value, 18, name = survival, languageSuffix = languageSuffix.value),
            )
        }
        val valuesPL = createSkillTranslationEntities(
            languageSuffix = LanguageSuffix.PL,
            "Akrobatyka",
            "Wiedza o Zwierzętach",
            "Arkanizm",
            "Atletyka",
            "Blef",
            "Historia",
            "Intuicja",
            "Zastraszanie",
            "Śledztwo",
            "Medycyna",
            "Natura",
            "Percepcja",
            "Występy",
            "Perswazja",
            "Religia",
            "Zręczne Dłonie",
            "Skradanie",
            "Sztuka Przetrwania",
        )
        val valuesEN = createSkillTranslationEntities(
            languageSuffix = LanguageSuffix.EN,
            "Acrobatics",
            "Animal Handling",
            "Arcana",
            "Athletics",
            "Deception",
            "History",
            "Insight",
            "Intimidation",
            "Investigation",
            "Medicine",
            "Nature",
            "Perception",
            "Performance",
            "Persuasion",
            "Religion",
            "Sleight of Hand",
            "Stealth",
            "Survival"
        )
    }
}
