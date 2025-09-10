package com.miltent.featureCharacterCreation.baseInfo.validator

import com.miltent.domain.model.Attribute
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import javax.inject.Inject

class BaseInfoValidatorImpl @Inject constructor() : BaseInfoValidator {
    override fun areFieldsValid(
        name: String,
        race: Race?,
        characterClass: CharacterClass?,
        strength: Attribute,
        dexterity: Attribute,
        constitution: Attribute,
        intelligence: Attribute,
        wisdom: Attribute,
        charisma: Attribute
    ): ValidationError? {
        if (name.isBlank()) return ValidationError.EmptyName
        if (strength.value > 18) return ValidationError.StrengthTooHigh
        if (dexterity.value > 18) return ValidationError.DexterityTooHigh
        if (constitution.value > 18) return ValidationError.ConstitutionTooHigh
        if (intelligence.value > 18) return ValidationError.IntelligenceTooHigh
        if (wisdom.value > 18) return ValidationError.WisdomTooHigh
        if (charisma.value > 18) return ValidationError.CharismaTooHigh
        if (race == null) return ValidationError.EmptyRace
        if (characterClass == null) return ValidationError.EmptyClass
        return null
    }
}