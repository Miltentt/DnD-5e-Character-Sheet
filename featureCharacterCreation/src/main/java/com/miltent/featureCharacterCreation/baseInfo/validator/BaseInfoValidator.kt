package com.miltent.featureCharacterCreation.baseInfo.validator

import com.miltent.domain.model.Attribute
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race

interface BaseInfoValidator {
    fun areFieldsValid(
        name: String,
        race: Race?,
        characterClass: CharacterClass?,
        strength: Attribute,
        dexterity: Attribute,
        constitution: Attribute,
        intelligence: Attribute,
        wisdom: Attribute,
        charisma: Attribute
    ): ValidationError?
}