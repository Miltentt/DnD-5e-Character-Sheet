package com.miltent.featureCharacterCreation.fightingStyle.intent

import com.miltent.core.intent.Intent
import com.miltent.domain.model.SpecialAbility

sealed interface FightingStyleIntent : Intent {
    data class OnFightingStyleChosen(val id: String): FightingStyleIntent
    data object OnNextClicked: FightingStyleIntent
}