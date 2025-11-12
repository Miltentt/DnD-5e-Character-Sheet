package com.miltent.featureCharacterCreation.baseInfo.validator

import com.miltent.domain.model.Attribute
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.domain.model.StatisticType

interface BaseInfoValidator {
    fun areFieldsValid(
        name: String,
        race: Race?,
        characterClass: CharacterClass?,
        uiAttributes: Map<StatisticType, Attribute?>,
    ): List<ValidationError>
}