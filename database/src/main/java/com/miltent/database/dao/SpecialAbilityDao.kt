package com.miltent.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.miltent.database.entities.specialAbility.SpecialAbilityEntity
import com.miltent.database.entities.specialAbility.SpecialAbilityTranslationEntity

@Dao
interface SpecialAbilityDao {

    @Query("SELECT * FROM ${SpecialAbilityEntity.TABLE_NAME}")
    suspend fun getSpecialAbilities(): List<SpecialAbilityEntity>

    @Query("SELECT * FROM ${SpecialAbilityTranslationEntity.TABLE_NAME} WHERE languageSuffix = :language")
    suspend fun getSpecialAbilitiesTranslations(language: String): List<SpecialAbilityTranslationEntity>

    @Query("SELECT * FROM ${SpecialAbilityEntity.TABLE_NAME} WHERE type = :type")
    suspend fun getSpecialByTypeAbilities(type: String): List<SpecialAbilityEntity>

    @Transaction
    suspend fun getAllSpecialAbilities(language: String): Map<SpecialAbilityEntity, SpecialAbilityTranslationEntity?> =
        getSpecialAbilities().associateWith { specialAbility ->
            getSpecialAbilitiesTranslations(
                language
            ).find { it.specialAbilityId == specialAbility.id }
        }

    @Transaction
    suspend fun getAllSpecialAbilitiesByType(
        language: String,
        type: String
    ): Map<SpecialAbilityEntity, SpecialAbilityTranslationEntity?> =
        getSpecialByTypeAbilities(type).associateWith { specialAbility ->
            getSpecialAbilitiesTranslations(language).find { it.specialAbilityId == specialAbility.id }
        }
}