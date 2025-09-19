package com.miltent.featureCharacterCreation.skills.intent

import com.miltent.core.intent.Intent

sealed interface SkillsIntent : Intent {

    data class OnSkillClicked(val id: String): SkillsIntent
    data object OnNextClicked: SkillsIntent
}