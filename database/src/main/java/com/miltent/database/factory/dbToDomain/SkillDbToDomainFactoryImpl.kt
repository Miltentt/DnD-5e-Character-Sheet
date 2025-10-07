package com.miltent.database.factory.dbToDomain

import com.miltent.database.entities.skills.SkillEntity
import com.miltent.database.entities.skills.SkillTranslationEntity
import com.miltent.domain.model.Skill
import com.miltent.domain.model.StatisticType
import javax.inject.Inject

class SkillDbToDomainFactoryImpl @Inject constructor(): SkillDbToDomainFactory {
    override fun create(
        value: SkillEntity,
        skillTranslationEntity: SkillTranslationEntity?
    ): Skill = Skill(
        id = value.id,
        name = skillTranslationEntity?.name.orEmpty(),
        statisticType = StatisticType.valueOf(value.statisticType)
    )
}