package com.miltent.featureCharacterCreation.baseInfo.intent

import com.miltent.core.intent.Intent
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.featureCharacterCreation.baseInfo.model.StatisticType

sealed interface BaseInfoIntent: Intent {
    data class OnNameChanged(val name: String) : BaseInfoIntent
    data class OnStatisticChanged(val statisticValue: String, val statisticType: StatisticType) : BaseInfoIntent
    data class OnCharacterClassChosen(val characterClass: CharacterClass) : BaseInfoIntent
    data class OnRaceChosen(val race: Race) : BaseInfoIntent
    object OnNextClicked : BaseInfoIntent
}