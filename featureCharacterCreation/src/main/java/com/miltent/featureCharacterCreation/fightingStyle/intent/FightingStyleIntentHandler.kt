package com.miltent.featureCharacterCreation.fightingStyle.intent

import android.util.Log
import androidx.compose.ui.res.stringResource
import com.miltent.core.characterprogression.CharacterProgression
import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.useCase.GetFighterStylesUseCase
import com.miltent.domain.model.Character
import com.miltent.featureCharacterCreation.creationNavigator.CharacterCreationNavigationStateHolder
import com.miltent.featureCharacterCreation.fightingStyle.event.FightingStyleEvent
import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleViewState
import com.miltent.featureCharacterCreation.fightingStyle.validation.FightingStyleValidator
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
internal class FightingStyleIntentHandler @Inject constructor(
    private val eventHandler: EventHandler<FightingStyleEvent>,
    private val characterCreationNavigationStateHolder: CharacterCreationNavigationStateHolder,
    private val characterCreationBuilder: Character.Builder1stLevel,
    private val viewStateProvider: ViewStateProvider<FightingStyleViewState>,
    private val fightingStyleValidator: FightingStyleValidator
) : IntentHandler<FightingStyleIntent> {

    override suspend fun handle(intent: FightingStyleIntent) = when (intent) {
        is FightingStyleIntent.OnFightingStyleChosen -> onFightingStyleChosen(intent.id)
        is FightingStyleIntent.OnNextClicked -> onNextClicked()
    }

    private suspend fun onNextClicked() {
        runCatching{
            viewStateProvider.updateState(viewStateProvider.viewState.value
                .copy(uiState = viewStateProvider.viewState.value.uiState
                    .copy(error = fightingStyleValidator.isValid(viewStateProvider.viewState.value.uiState.currentFightingStyle)))
            )
            val currentFightingStyle =
                requireNotNull(viewStateProvider.viewState.value.uiState.currentFightingStyle)
            characterCreationBuilder.specialAbility(currentFightingStyle)
            eventHandler.emitEvent(
                FightingStyleEvent.NextStep(
                    nextStepRoute = requireNotNull(
                        characterCreationNavigationStateHolder.provideNextCharacterCreationStep( currentStep = CharacterProgression.FightingStyle)
                    )
                )
            )
        }.onFailure {
            // todo error handling
        }
    }

    private fun onFightingStyleChosen(specialAbilityId: String) {
        viewStateProvider.updateState(
            viewStateProvider.viewState.value.copy(
                uiState = viewStateProvider.viewState.value.uiState.copy(
                    currentFightingStyle = viewStateProvider.viewState.value.fightingStyles.find { fightingStyle ->
                        fightingStyle.id == specialAbilityId
                    },
                    error = null
                )
            )
        )
    }
}