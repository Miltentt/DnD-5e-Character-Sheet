package com.miltent.database.factory.dbToDomain

import com.miltent.database.entities.skills.SkillEntity
import com.miltent.database.entities.skills.SkillTranslationEntity
import com.miltent.domain.model.Skill

interface SkillDbToDomainFactory {
    fun create(
        value: SkillEntity,
        skillTranslationEntity: SkillTranslationEntity?
    ): Skill
}