package com.miltent.featureCharacterCreation.fightingStyle.validation

import com.miltent.domain.model.Attribute
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.domain.model.SpecialAbility

interface FightingStyleValidator {
    fun isValid(
        fightingStyle: SpecialAbility?,
    ): ValidationError?
}