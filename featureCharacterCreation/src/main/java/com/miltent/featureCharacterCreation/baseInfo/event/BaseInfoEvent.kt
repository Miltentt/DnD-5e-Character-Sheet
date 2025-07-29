package com.miltent.featureCharacterCreation.baseInfo.event

import com.miltent.core.event.Event
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute

sealed interface BaseInfoEvent: Event {

    data class NextStep(val nextStepRoute: CharacterCreationRoute): BaseInfoEvent
}