package com.miltent.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.miltent.database.entities.skills.SkillEntity
import com.miltent.database.entities.skills.SkillTranslationEntity

@Dao
interface SkillsDao {

    @Query("SELECT * FROM ${SkillEntity.TABLE_NAME}")
    suspend fun getSkills(): List<SkillEntity>

    @Query("SELECT * FROM ${SkillTranslationEntity.TABLE_NAME} WHERE languageSuffix = :language")
    suspend fun getSkillTranslations(language: String): List<SkillTranslationEntity>

    @Transaction
    suspend fun getAllSkills(language: String): Map<SkillEntity, SkillTranslationEntity?> =
        getSkills().associateWith { skill ->
            getSkillTranslations(language).find { it.skillId == skill.id }
        }
}