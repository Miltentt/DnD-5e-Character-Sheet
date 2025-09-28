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
    ): List<ValidationError> {
        val errors = emptyList<ValidationError>().toMutableList()
        if (name.isBlank()) errors += ValidationError.EmptyName
        if (strength.value > 18) errors += ValidationError.StrengthTooHigh
        if (dexterity.value > 18) errors += ValidationError.DexterityTooHigh
        if (constitution.value > 18) errors += ValidationError.ConstitutionTooHigh
        if (intelligence.value > 18) errors += ValidationError.IntelligenceTooHigh
        if (wisdom.value > 18) errors += ValidationError.WisdomTooHigh
        if (charisma.value > 18) errors += ValidationError.CharismaTooHigh
        if (race == null) errors += ValidationError.EmptyRace
        if (characterClass == null) errors += ValidationError.EmptyClass
        return errors
    }
}