package com.miltent.featureCharacterCreation.baseInfo.validator

import com.miltent.domain.model.Attribute
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.domain.model.StatisticType
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
        val validationErrorList = mutableListOf<ValidationError>()
        
        if (name.isBlank())
            validationErrorList += ValidationError.EmptyName
        if (strength.value !in Attribute.baseValueRange)
            validationErrorList += ValidationError.AttributeOutOfRange(StatisticType.STR)
        if (dexterity.value !in Attribute.baseValueRange)
            validationErrorList += ValidationError.AttributeOutOfRange(StatisticType.DEX)
        if (constitution.value !in Attribute.baseValueRange)
            validationErrorList += ValidationError.AttributeOutOfRange(StatisticType.CON)
        if (intelligence.value !in Attribute.baseValueRange)
            validationErrorList += ValidationError.AttributeOutOfRange(StatisticType.INT)
        if (wisdom.value !in Attribute.baseValueRange)
            validationErrorList += ValidationError.AttributeOutOfRange(StatisticType.WIS)
        if (charisma.value !in Attribute.baseValueRange)
            validationErrorList += ValidationError.AttributeOutOfRange(StatisticType.CHA)
        if (race == null)
            validationErrorList += ValidationError.EmptyRace
        if (characterClass == null) validationErrorList += ValidationError.EmptyClass
        return validationErrorList
    }
}