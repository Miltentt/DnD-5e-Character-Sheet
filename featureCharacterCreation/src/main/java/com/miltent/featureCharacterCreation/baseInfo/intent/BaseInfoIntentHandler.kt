package com.miltent.featureCharacterCreation.baseInfo.intent

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Character
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.featureCharacterCreation.baseInfo.event.BaseInfoEvent
import com.miltent.featureCharacterCreation.baseInfo.model.StatisticType
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoViewState
import com.miltent.featureCharacterCreation.creationNavigator.CharacterCreationNavigationStateHolder
import com.miltent.featureCharacterCreation.factory.CharacterProgressionFactory
import javax.inject.Inject

class BaseInfoIntentHandler @Inject constructor(
    private val viewStateProvider: ViewStateProvider<BaseInfoViewState>,
    private val characterCreationNavigationStateHolder: CharacterCreationNavigationStateHolder,
    private val characterProgressionFactory: CharacterProgressionFactory,
    private val eventHandler: EventHandler<BaseInfoEvent>,
    private val character1stLevelBuilder: Character.Builder1stLevel
) : IntentHandler<BaseInfoIntent> {
    override suspend fun handle(intent: BaseInfoIntent) = when (intent) {
        is BaseInfoIntent.OnRaceChosen -> updateRace(intent.race)
        is BaseInfoIntent.OnNameChanged -> updateName(intent.name)
        is BaseInfoIntent.OnStatisticChanged -> updateStatistic(
            intent.statisticValue,
            intent.statisticType
        )

        is BaseInfoIntent.OnCharacterClassChosen -> updateCharacterClass(intent.characterClass)
        is BaseInfoIntent.OnNextClicked -> onNextClicked()
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

    private suspend fun onNextClicked() {
        character1stLevelBuilder.baseInfo(
            name = viewStateProvider.viewState.value.uiState.name,
            race = viewStateProvider.viewState.value.uiState.race,
            characterClass = viewStateProvider.viewState.value.uiState.characterClass,
            baseCharisma = Attribute(viewStateProvider.viewState.value.uiState.charisma),
            baseConstitution = Attribute(viewStateProvider.viewState.value.uiState.constitution),
            baseDexterity = Attribute(viewStateProvider.viewState.value.uiState.dexterity),
            baseIntelligence = Attribute(viewStateProvider.viewState.value.uiState.intelligence),
            baseStrength = Attribute(viewStateProvider.viewState.value.uiState.strength),
            baseWisdom = Attribute(viewStateProvider.viewState.value.uiState.wisdom)
        )

        characterCreationNavigationStateHolder.initialize(
            characterProgressionFactory.create(
                race = viewStateProvider.viewState.value.uiState.race,
                characterClass = viewStateProvider.viewState.value.uiState.characterClass
            )
        )
        eventHandler.emitEvent(
            BaseInfoEvent.NextStep(
                nextStepRoute = requireNotNull(
                    characterCreationNavigationStateHolder.provideNextCharacterCreationStep()
                )
            )
        )
    }
}
