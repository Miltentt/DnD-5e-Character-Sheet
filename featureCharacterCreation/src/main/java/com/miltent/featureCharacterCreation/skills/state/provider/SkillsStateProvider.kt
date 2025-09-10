package com.miltent.featureCharacterCreation.skills.state.provider

import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.useCase.GetDefaultSkillsUseCase
import com.miltent.core.utility.Queue
import com.miltent.designsystem.skills.Skill
import com.miltent.domain.model.Character
import com.miltent.domain.model.StatisticType
import com.miltent.featureCharacterCreation.skills.state.SkillsUiState
import com.miltent.featureCharacterCreation.skills.state.SkillsViewState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@ViewModelScoped
class SkillsStateProvider @Inject constructor(
    private val getSkillsUseCase: GetDefaultSkillsUseCase,
    private val character1stLevelBuilder: Character.Builder1stLevel,
) : ViewStateProvider<SkillsViewState>() {

    override val _viewState: MutableStateFlow<SkillsViewState> = MutableStateFlow(getEmpty())

    private fun getEmpty(): SkillsViewState {
        val skills = getSkillsUseCase.invoke()
        return SkillsViewState(SkillsUiState(
            Queue(4)
        ), skills.associate {
            when(it.statisticType) {
                StatisticType.CHA -> it to 4
                StatisticType.CON -> it to 5
                StatisticType.DEX -> it to 6
                StatisticType.INT -> it to 7
                StatisticType.STR -> it to 8
                StatisticType.WIS -> it to 9
            }
        })
    }

}