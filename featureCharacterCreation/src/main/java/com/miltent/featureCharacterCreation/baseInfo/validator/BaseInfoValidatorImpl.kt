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
        startAttributes: Map<StatisticType, Attribute?>,
    ): List<ValidationError> {
        val validationErrorList = mutableListOf<ValidationError>()

        StatisticType.entries.forEach {
            val attributeValue = startAttributes.getValue(it)?.value
            when (attributeValue) {
                null -> validationErrorList += ValidationError.EmptyAttribute(it)
                !in Attribute.baseValueRange -> validationErrorList += ValidationError.AttributeOutOfRange(it)
            }
        }
        if (name.isBlank())
            validationErrorList += ValidationError.EmptyName
        if (race == null)
            validationErrorList += ValidationError.EmptyRace
        if (characterClass == null) validationErrorList += ValidationError.EmptyClass
        return validationErrorList
    }
}