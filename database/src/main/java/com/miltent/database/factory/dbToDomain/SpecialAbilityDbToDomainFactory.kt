package com.miltent.database.factory.dbToDomain

import com.miltent.database.entities.specialAbility.SpecialAbilityEntity
import com.miltent.database.entities.specialAbility.SpecialAbilityTranslationEntity
import com.miltent.domain.model.SpecialAbility

interface SpecialAbilityDbToDomainFactory {
    fun create(
        value: SpecialAbilityEntity,
        specialAbilityTranslationEntity: SpecialAbilityTranslationEntity?
    ): SpecialAbility

}