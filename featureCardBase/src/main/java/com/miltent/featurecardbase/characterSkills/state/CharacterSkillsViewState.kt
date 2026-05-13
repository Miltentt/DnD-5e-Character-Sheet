package com.miltent.featurecardbase.characterSkills.state

import com.miltent.core.ui.ViewState
import com.miltent.domain.model.SkillWithModifier

data class CharacterSkillsViewState(val skills: List<SkillWithModifier>) : ViewState