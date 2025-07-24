package com.miltent.featureCharacterCreation.baseInfo.intent

import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.featureCharacterCreation.baseInfo.model.StatisticType
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoViewState
import javax.inject.Inject

class BaseInfoIntentHandler @Inject constructor(
    private val viewStateProvider: ViewStateProvider<BaseInfoViewState>,
) : IntentHandler<BaseInfoIntent> {
    override fun handle(intent: BaseInfoIntent) = when (intent) {
        is BaseInfoIntent.OnRaceChosen -> updateRace(intent.race)
        is BaseInfoIntent.OnNameChanged -> updateName(intent.name)
        is BaseInfoIntent.OnStatisticChanged -> updateStatistic(intent.statisticValue, intent.statisticType)
        is BaseInfoIntent.OnCharacterClassChosen -> updateCharacterClass(intent.characterClass)
    }

    private fun updateRace(race: Race) {
        viewStateProvider.updateState(
            viewStateProvider.viewState.value.copy(
                uiState = viewStateProvider.viewState.value.uiState.copy(race = race)
            )
        )
    }

    private fun updateName(name: String) {
        viewStateProvider.updateState(
            viewStateProvider.viewState.value.copy(
                uiState = viewStateProvider.viewState.value.uiState.copy(name = name)
            )
        )
    }

    private fun updateStatistic(statisticValue: String, statisticType: StatisticType) {
        with(viewStateProvider.viewState.value) {
            viewStateProvider.updateState(
                copy(
                    uiState =
                        when (statisticType) {
                            StatisticType.STR -> uiState.copy(strength = statisticValue.toInt())
                            StatisticType.DEX -> uiState.copy(dexterity = statisticValue.toInt())
                            StatisticType.CON -> uiState.copy(constitution = statisticValue.toInt())
                            StatisticType.INT -> uiState.copy(intelligence = statisticValue.toInt())
                            StatisticType.WIS -> uiState.copy(wisdom = statisticValue.toInt())
                            StatisticType.CHA -> uiState.copy(charisma = statisticValue.toInt())
                        }
                )
            )
        }
    }

    private fun updateCharacterClass(characterClass: CharacterClass) {
        viewStateProvider.updateState(
            viewStateProvider.viewState.value.copy(
                uiState = viewStateProvider.viewState.value.uiState.copy(characterClass = characterClass)
            )
        )
    }
}
