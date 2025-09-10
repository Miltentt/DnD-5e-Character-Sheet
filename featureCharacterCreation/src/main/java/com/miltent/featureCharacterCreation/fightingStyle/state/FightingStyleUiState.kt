package com.miltent.featureCharacterCreation.fightingStyle.state

import com.miltent.domain.model.SpecialAbility
import com.miltent.featureCharacterCreation.fightingStyle.validation.ValidationError

data class FightingStyleUiState(val currentFightingStyle: SpecialAbility?, val error: ValidationError?)