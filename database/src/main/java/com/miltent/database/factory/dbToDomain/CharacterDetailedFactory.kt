package com.miltent.database.factory.dbToDomain

import com.miltent.database.entities.character.CharacterWithSkillsAndSpecialAbilitiesEntity
import com.miltent.database.entities.skills.SkillTranslationEntity
import com.miltent.database.entities.specialAbility.SpecialAbilityTranslationEntity
import com.miltent.domain.model.CharacterDetailed

interface CharacterDetailedFactory {
    fun create(
        characterWithAdditionalInfo: CharacterWithSkillsAndSpecialAbilitiesEntity,
        skillTranslations: List<SkillTranslationEntity>,
        specialAbilityTranslations: List<SpecialAbilityTranslationEntity>
    ): CharacterDetailed
}