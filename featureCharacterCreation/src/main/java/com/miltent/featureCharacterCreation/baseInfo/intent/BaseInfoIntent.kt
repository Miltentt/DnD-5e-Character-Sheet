package com.miltent.featureCharacterCreation.baseInfo.intent

import com.miltent.core.intent.Intent
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.domain.model.StatisticType

sealed interface BaseInfoIntent: Intent {
    data class OnNameChanged(val name: String) : BaseInfoIntent
    data class OnStatisticsChanged(val statisticType: StatisticType, val attribute: Attribute) : BaseInfoIntent
    data class OnCharacterClassChosen(val characterClassIdentifier: String) : BaseInfoIntent
    data class OnRaceChosen(val raceIdentifier: String) : BaseInfoIntent
    object OnNextClicked : BaseInfoIntent
}