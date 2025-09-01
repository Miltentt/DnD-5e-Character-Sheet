package com.miltent.featureCharacterCreation.skills.event

import com.miltent.core.event.Event
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute

sealed interface SkillsEvent : Event {
    data object FinishProcess: SkillsEvent
    data object NavigateToError: SkillsEvent
}