package com.miltent.featureCharacterCreation.skills.intent

import com.miltent.core.intent.Intent

sealed interface SkillsIntent : Intent {

    data class OnSkillToggled(val id: Int,val isChecked: Boolean): SkillsIntent
    data object OnNextClicked: SkillsIntent
}