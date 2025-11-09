package com.miltent.featureCharacterCreation.baseInfo.state

import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Attributes
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.featureCharacterCreation.baseInfo.validator.ValidationError

data class BaseInfoUiState(
    val name: String,
    val attributes: Attributes,
    val race: Race?,
    val characterClass: CharacterClass?,
    val error: ValidationError?,
)