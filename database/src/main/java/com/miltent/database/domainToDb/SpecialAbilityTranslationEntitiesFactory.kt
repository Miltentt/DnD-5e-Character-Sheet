package com.miltent.database.domainToDb

import com.miltent.database.entities.specialAbility.SpecialAbilityTranslationEntity
import com.miltent.domain.model.LanguageSuffix
import java.util.UUID

class SpecialAbilityTranslationEntitiesFactory {
    companion object{
        fun createSpecialAbilityTranslationEntity(language: String, specialAbilityId: String): SpecialAbilityTranslationEntity {
            val id = UUID.randomUUID().toString()
            return SpecialAbilityTranslationEntity(
                id = id,
                specialAbilityId = specialAbilityId,
                languageSuffix = language,
                name = "name:$id",
                description = "description:$id"
            )
        }
    }

}