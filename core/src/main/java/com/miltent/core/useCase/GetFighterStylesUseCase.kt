package com.miltent.core.useCase

import android.content.Context
import com.miltent.core.repository.SpecialAbilityRepository
import com.miltent.domain.model.SpecialAbility
import com.miltent.domain.model.SpecialAbilityType
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetFighterStylesUseCase @Inject constructor(
    private val specialAbilityRepository: SpecialAbilityRepository,
    @ApplicationContext private val context: Context
) {

    suspend operator fun invoke(): List<SpecialAbility> {
        val language = context.resources.configuration.locales[0].language
        return specialAbilityRepository.getSpecialAbilitiesByType(
            type = SpecialAbilityType.FightingStyle,
            language
        )
    }
}