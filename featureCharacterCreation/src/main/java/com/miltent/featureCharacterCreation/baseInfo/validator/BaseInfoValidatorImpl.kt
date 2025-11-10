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
        if (strength.value !in Attribute.baseValueRange) return ValidationError.StrengthTooHigh
        if (dexterity.value !in Attribute.baseValueRange) return ValidationError.DexterityTooHigh
        if (constitution.value !in Attribute.baseValueRange) return ValidationError.ConstitutionTooHigh
        if (intelligence.value !in Attribute.baseValueRange) return ValidationError.IntelligenceTooHigh
        if (wisdom.value !in Attribute.baseValueRange) return ValidationError.WisdomTooHigh
        if (charisma.value !in Attribute.baseValueRange) return ValidationError.CharismaTooHigh
        if (race == null) return ValidationError.EmptyRace
        if (characterClass == null) return ValidationError.EmptyClass
        return null
    }
}