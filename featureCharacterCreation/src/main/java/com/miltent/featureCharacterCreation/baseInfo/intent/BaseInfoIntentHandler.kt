package com.miltent.featureCharacterCreation.baseInfo.intent

import com.miltent.core.characterprogression.CharacterProgression
import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Character
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.domain.model.StatisticType
import com.miltent.featureCharacterCreation.baseInfo.event.BaseInfoEvent
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoViewState
import com.miltent.featureCharacterCreation.baseInfo.validator.BaseInfoValidator
import com.miltent.featureCharacterCreation.creationNavigator.CharacterCreationNavigationStateHolder
import com.miltent.featureCharacterCreation.factory.CharacterProgressionFactory
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
@ViewModelScoped
class BaseInfoIntentHandler @Inject constructor(
    private val viewStateProvider: ViewStateProvider<BaseInfoViewState>,
    private val characterCreationNavigationStateHolder: CharacterCreationNavigationStateHolder,
    private val characterProgressionFactory: CharacterProgressionFactory,
    private val eventHandler: EventHandler<BaseInfoEvent>,
    private val character1stLevelBuilder: Character.Builder1stLevel,
    private val validator: BaseInfoValidator,
) : IntentHandler<BaseInfoIntent> {
    override suspend fun handle(intent: BaseInfoIntent) = when (intent) {
        is BaseInfoIntent.OnRaceChosen -> updateRace(intent.raceIdentifier)
        is BaseInfoIntent.OnNameChanged -> updateName(intent.name)
        is BaseInfoIntent.OnStatisticChanged -> updateStatistic(
            intent.statisticValue,
            intent.statisticType
        )

        is BaseInfoIntent.OnCharacterClassChosen -> updateCharacterClass(intent.characterClass)
        is BaseInfoIntent.OnNextClicked -> onNextClicked()
    }

    private fun updateRace(raceIdentifier: String) {
        viewStateProvider.updateState(
            viewStateProvider.viewState.value.copy(
                uiState = viewStateProvider.viewState.value.uiState.copy(race = Race.entries.find { it.identifier == raceIdentifier })
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
                            StatisticType.STR -> uiState.copy(strength = Attribute.fromString(value = statisticValue))
                            StatisticType.DEX -> uiState.copy(dexterity = Attribute.fromString(value = statisticValue))
                            StatisticType.CON -> uiState.copy(
                                constitution = Attribute.fromString(
                                    value = statisticValue
                                )
                            )

                            StatisticType.INT -> uiState.copy(
                                intelligence = Attribute.fromString(
                                    value = statisticValue
                                )
                            )

                            StatisticType.WIS -> uiState.copy(wisdom = Attribute.fromString(value = statisticValue))
                            StatisticType.CHA -> uiState.copy(charisma = Attribute.fromString(value = statisticValue))
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
        viewStateProvider.updateState(
            viewStateProvider.viewState.value.copy(
                uiState = viewStateProvider.viewState.value.uiState.copy(
                    errors = validator.areFieldsValid(
                        name = viewStateProvider.viewState.value.uiState.name,
                        race = viewStateProvider.viewState.value.uiState.race,
                        characterClass = viewStateProvider.viewState.value.uiState.characterClass,
                        strength = viewStateProvider.viewState.value.uiState.strength,
                        dexterity = viewStateProvider.viewState.value.uiState.dexterity,
                        constitution = viewStateProvider.viewState.value.uiState.constitution,
                        intelligence = viewStateProvider.viewState.value.uiState.intelligence,
                        wisdom = viewStateProvider.viewState.value.uiState.wisdom,
                        charisma = viewStateProvider.viewState.value.uiState.charisma
                    )
                )
            )
        )

        if (viewStateProvider.viewState.value.uiState.errors.isNotEmpty()) return
        runCatching {
            val race = requireNotNull(viewStateProvider.viewState.value.uiState.race)
            val characterClass =
                requireNotNull(viewStateProvider.viewState.value.uiState.characterClass)

            character1stLevelBuilder.baseInfo(
                name = viewStateProvider.viewState.value.uiState.name,
                race = race,
                characterClass = characterClass,
                baseCharisma = viewStateProvider.viewState.value.uiState.charisma,
                baseConstitution = viewStateProvider.viewState.value.uiState.constitution,
                baseDexterity = viewStateProvider.viewState.value.uiState.dexterity,
                baseIntelligence = viewStateProvider.viewState.value.uiState.intelligence,
                baseStrength = viewStateProvider.viewState.value.uiState.strength,
                baseWisdom = viewStateProvider.viewState.value.uiState.wisdom
            )

            characterCreationNavigationStateHolder.initialize(
                characterProgressionFactory.create(
                    race = race,
                    characterClass = characterClass
                )
            )

        }.onSuccess {
            eventHandler.emitEvent(
                BaseInfoEvent.NextStep(
                    nextStepRoute = requireNotNull(
                        characterCreationNavigationStateHolder.provideNextCharacterCreationStep(
                            currentStep = CharacterProgression.BaseInfo)
                    )
                )
            )
        }.onFailure {
            // todo error handling
        }
    }
}
