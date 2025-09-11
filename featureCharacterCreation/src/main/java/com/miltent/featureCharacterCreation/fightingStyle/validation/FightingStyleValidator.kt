package com.miltent.featureCharacterCreation.fightingStyle.validation

import com.miltent.domain.model.SpecialAbility

interface FightingStyleValidator {
    fun isValid(
        fightingStyle: SpecialAbility?,
    ): ValidationError?
}