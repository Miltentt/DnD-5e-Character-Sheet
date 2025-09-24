package com.miltent.featureCharacterCreation.skills.state.provider

import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.useCase.GetDefaultSkillsUseCase
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
        val skillPoints = character1stLevelBuilder.race.skillPoints + character1stLevelBuilder.characterClass.skillPoints
        val skills = getSkillsUseCase.invoke()
        return SkillsViewState(
            SkillsUiState(
                skillpointsLeft = skillPoints,
                selectedSkills = listOf(),
                skillPoints = skillPoints,
            ), skills.associate {
                when (it.statisticType) {
                    StatisticType.CHA -> it to character1stLevelBuilder.baseCharisma.calculateModifier()
                    StatisticType.CON -> it to character1stLevelBuilder.baseConstitution.calculateModifier()
                    StatisticType.DEX -> it to character1stLevelBuilder.baseDexterity.calculateModifier()
                    StatisticType.INT -> it to character1stLevelBuilder.baseIntelligence.calculateModifier()
                    StatisticType.STR -> it to character1stLevelBuilder.baseStrength.calculateModifier()
                    StatisticType.WIS -> it to character1stLevelBuilder.baseWisdom.calculateModifier()
                }
            }
        )
    }

}