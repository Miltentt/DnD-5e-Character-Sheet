package com.miltent.featureCharacterCreation.fightingStyle.event

import com.miltent.core.event.Event
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute

sealed interface FightingStyleEvent : Event {
    data class NextStep(val nextStepRoute: CharacterCreationRoute) : FightingStyleEvent
}