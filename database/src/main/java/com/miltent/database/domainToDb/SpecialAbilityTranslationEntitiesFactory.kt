package com.miltent.database.domainToDb

import com.miltent.database.entities.specialAbility.SpecialAbilityTranslationEntity
import com.miltent.domain.model.LanguageSuffix
import java.util.UUID

class SpecialAbilityTranslationEntitiesFactory {
    companion object{
        fun createSpecialAbilityTranslationEntity(
            language: String,
            specialAbilityId: String,
            name: String
        ): SpecialAbilityTranslationEntity {
            val id = UUID.randomUUID().toString()
            return SpecialAbilityTranslationEntity(
                id = id,
                specialAbilityId = specialAbilityId,
                languageSuffix = language,
                name = name,
                description = "description:$name"
            )
        }
        fun createSpecialAbilityTranslationEntities(): List<SpecialAbilityTranslationEntity> {
            val enFightingStyleNames = listOf<String>(
                "Archery",
                "Defense",
                "Dueling",
                "Great Weapon Fighting",
                "Protection",
                "Two-Weapon Fighting",
                "Blind Fighting",
                "Interception",
                "Thrown Weapon Fighting",
                "Superior Technique",
                "Unarmed Fighting"
            )
            val plFightingStyleNames = listOf<String>(
                "Łucznictwo",
                "Obrona",
                "Pojedynkowanie",
                "Walka Wielką Bronią",
                "Ochrona",
                "Walka Dwoma Broniami",
                "Walka na Oślep",
                "Przechwycenie",
                "Walka Bronią Miotaną",
                "Technika Mistrzowska",
                "Walka Bez Broni"
            )
            val languageFightingStyleNames = mapOf<LanguageSuffix, List<String>>(
                LanguageSuffix.PL to plFightingStyleNames,
                LanguageSuffix.EN to enFightingStyleNames
            )
            val listOfSpecialAbilityTranslations: MutableList<SpecialAbilityTranslationEntity> =
                mutableListOf()
            languageFightingStyleNames.forEach { (language, names) ->
                listOfSpecialAbilityTranslations += names.mapIndexed { index, name ->
                    createSpecialAbilityTranslationEntity(
                        language.value,
                        SpecialAbilityEntityFactory.someSpecialAbilities[index].id, name
                    )
                }
            }
            return listOfSpecialAbilityTranslations
        }
    }
}