package com.miltent.core.repository

import com.miltent.domain.model.SpecialAbility
import com.miltent.domain.model.SpecialAbilityType

interface SpecialAbilityRepository {

    suspend fun getAllSpecialAbilities(language: String): List<SpecialAbility>

    suspend fun getSpecialAbilitiesByType(
        type: SpecialAbilityType,
        language: String
    ): List<SpecialAbility>
}