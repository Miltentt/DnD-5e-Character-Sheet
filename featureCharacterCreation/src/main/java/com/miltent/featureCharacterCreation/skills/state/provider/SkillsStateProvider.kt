package com.miltent.featureCharacterCreation.skills.state.provider

import com.miltent.core.ui.ViewStateProvider
import com.miltent.featureCharacterCreation.skills.state.SkillsUiState
import com.miltent.featureCharacterCreation.skills.state.SkillsViewState
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class SkillsStateProvider @Inject constructor(
) : ViewStateProvider<SkillsViewState>() {

    override val _viewState: MutableStateFlow<SkillsViewState> =
        MutableStateFlow(SkillsViewState(SkillsUiState()))

}