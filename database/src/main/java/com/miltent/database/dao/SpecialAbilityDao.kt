package com.miltent.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.miltent.database.domainToDb.SpecialAbilityEntityFactory
import com.miltent.database.domainToDb.SpecialAbilityTranslationEntitiesFactory
import com.miltent.database.entities.specialAbility.SpecialAbilityEntity
import com.miltent.database.entities.specialAbility.SpecialAbilityTranslationEntity

@Dao
interface SpecialAbilityDao {

    @Insert
    suspend fun insertSomeSpecialAbilities(someAbilities: List<SpecialAbilityEntity>)
    @Insert
    suspend fun insertSomeSpecialAbilityTranslations(someTranslations: List<SpecialAbilityTranslationEntity>)
    @Transaction
    suspend fun insertSomeSpecialAbilitiesWithTranslations(language: String){
        insertSomeSpecialAbilities(
            someAbilities = SpecialAbilityEntityFactory.someSpecialAbilities(),
        )
        insertSomeSpecialAbilityTranslations(
            someTranslations =
                SpecialAbilityEntityFactory.someSpecialAbilities()
                .map { SpecialAbilityTranslationEntitiesFactory.createSpecialAbilityTranslationEntity(
                    language,
                    specialAbilityId = it.id,
                )
                }
        )
    }

    @Query("SELECT * FROM ${SpecialAbilityEntity.TABLE_NAME}")
    suspend fun getSpecialAbilities(): List<SpecialAbilityEntity>

    @Query("SELECT * FROM ${SpecialAbilityTranslationEntity.TABLE_NAME} WHERE languageSuffix = :language")
    suspend fun getSpecialAbilityTranslations(language: String): List<SpecialAbilityTranslationEntity>

    @Query("SELECT * FROM ${SpecialAbilityEntity.TABLE_NAME} WHERE type = :type")
    suspend fun getSpecialByTypeAbilities(type: String): List<SpecialAbilityEntity>

    @Transaction
    suspend fun getAllSpecialAbilities(language: String): Map<SpecialAbilityEntity, SpecialAbilityTranslationEntity?> =
        getSpecialAbilities().associateWith { specialAbility ->
            getSpecialAbilityTranslations(
                language
            ).find { it.specialAbilityId == specialAbility.id }
        }

    @Transaction
    suspend fun getAllSpecialAbilitiesByType(
        language: String,
        type: String
    ): Map<SpecialAbilityEntity, SpecialAbilityTranslationEntity?> =
        getSpecialByTypeAbilities(type).associateWith { specialAbility ->
            getSpecialAbilityTranslations(language).find { it.specialAbilityId == specialAbility.id }
        }
}