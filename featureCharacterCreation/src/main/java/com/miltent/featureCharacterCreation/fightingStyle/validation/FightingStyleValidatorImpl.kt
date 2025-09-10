package com.miltent.featureCharacterCreation.fightingStyle.validation

import com.miltent.domain.model.SpecialAbility
import javax.inject.Inject

class FightingStyleValidatorImpl @Inject constructor() : FightingStyleValidator {
    override fun isValid(
       fightingStyle: SpecialAbility?
    ): ValidationError? {
        if (fightingStyle == null) return ValidationError.EmptyFightingStyle
        return null
    }
}