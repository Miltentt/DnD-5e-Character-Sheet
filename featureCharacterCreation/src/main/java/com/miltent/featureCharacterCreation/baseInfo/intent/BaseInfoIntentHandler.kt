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
import com.miltent.featureCharacterCreation.baseInfo.validator.BaseInfoValidator2
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
    private val validator: BaseInfoValidator2,
) : IntentHandler<BaseInfoIntent> {
    override suspend fun handle(intent: BaseInfoIntent) = when (intent) {
        is BaseInfoIntent.OnRaceChosen -> updateRace(intent.raceIdentifier)
        is BaseInfoIntent.OnNameChanged -> updateName(intent.name)
        is BaseInfoIntent.OnStatisticsChanged -> updateStatistic(
            intent.statisticType,
            intent.attribute
        )
        is BaseInfoIntent.OnCharacterClassChosen -> initiateCharacterClass(intent.characterClassIdentifier)
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

    private fun updateStatistic(statisticType: StatisticType, attribute: Attribute){
        with(viewStateProvider.viewState.value) {
            viewStateProvider.updateState(
                copy(
                    uiState = uiState.copy(
                        attributes =
                            uiState.attributes.updateAttribute(statisticType,attribute))
                )
            )
        }
    }


    private fun initiateCharacterClass(characterClassIdentifier: String) {
        viewStateProvider.updateState(
            viewStateProvider.viewState.value.copy(
                uiState = viewStateProvider.viewState.value.uiState
                    .copy(characterClass =
                        CharacterClass.createCharacterClass(1,characterClassIdentifier)
                    )
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
                        strength = viewStateProvider.viewState.value.uiState.attributes.values
                            .getValue(StatisticType.STR),
                        dexterity = viewStateProvider.viewState.value.uiState.attributes.values
                            .getValue(StatisticType.DEX),
                        constitution = viewStateProvider.viewState.value.uiState.attributes.values
                            .getValue(StatisticType.CON),
                        intelligence = viewStateProvider.viewState.value.uiState.attributes.values
                            .getValue(StatisticType.INT),
                        wisdom = viewStateProvider.viewState.value.uiState.attributes.values
                            .getValue(StatisticType.WIS),
                        charisma = viewStateProvider.viewState.value.uiState.attributes.values
                            .getValue(StatisticType.CHA)
                    )
                )
            )
        )

        if (viewStateProvider.viewState.value.uiState.error != null) return
        runCatching {
            val race = requireNotNull(viewStateProvider.viewState.value.uiState.race)
            val characterClass =
                requireNotNull(viewStateProvider.viewState.value.uiState.characterClass)

            character1stLevelBuilder.baseInfo(
                name = viewStateProvider.viewState.value.uiState.name,
                race = race,
                characterClass = characterClass,
                baseAttributes = viewStateProvider.viewState.value.uiState.attributes
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
