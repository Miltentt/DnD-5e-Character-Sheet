package com.miltent.database.repository

import com.miltent.core.repository.SpecialAbilityRepository
import com.miltent.database.dao.SpecialAbilityDao
import com.miltent.database.factory.dbToDomain.SpecialAbilityDbToDomainFactory
import com.miltent.domain.model.SpecialAbility
import com.miltent.domain.model.SpecialAbilityType
import javax.inject.Inject

class SpecialAbilityRepositoryImpl @Inject constructor(
    private val specialAbilityDao: SpecialAbilityDao,
    private val specialAbilityDbToDomainFactory: SpecialAbilityDbToDomainFactory
) : SpecialAbilityRepository {

    override suspend fun getAllSpecialAbilities(language: String): List<SpecialAbility> =
        specialAbilityDao.getAllSpecialAbilities(language).map { specialAbilityEntry ->
            specialAbilityDbToDomainFactory.create(
                specialAbilityEntry.key,
                specialAbilityEntry.value
            )
        }

    override suspend fun getSpecialAbilitiesByType(
        type: SpecialAbilityType,
        language: String
    ): List<SpecialAbility> = specialAbilityDao.getAllSpecialAbilitiesByType(language, type.value)
        .map { specialAbilityEntry ->
            specialAbilityDbToDomainFactory.create(
                specialAbilityEntry.key,
                specialAbilityEntry.value
            )
        }
}