package com.miltent.database.repository

import com.miltent.core.repository.SkillsRepository
import com.miltent.database.dao.SkillsDao
import com.miltent.database.factory.dbToDomain.SkillDbToDomainFactory
import com.miltent.domain.model.Skill
import javax.inject.Inject

class SkillsRepositoryImpl @Inject constructor(
    private val skillsDao: SkillsDao,
    private val skillDbToDomainFactory: SkillDbToDomainFactory
) : SkillsRepository {

    override suspend fun getAllSkills(language: String): List<Skill> =
        skillsDao.getAllSkills(language).map { skillEntry ->
            skillDbToDomainFactory.create(skillEntry.key, skillEntry.value)
        }
}