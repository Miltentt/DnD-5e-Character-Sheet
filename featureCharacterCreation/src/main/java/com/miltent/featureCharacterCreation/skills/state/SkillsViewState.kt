package com.miltent.featureCharacterCreation.skills.state

import com.miltent.core.ui.ViewState
import com.miltent.domain.model.Skill

data class SkillsViewState(val uiState: SkillsUiState, val skillList: Map<Skill, Int>): ViewState