package com.miltent.featureCharacterCreation.fightingStyle.intent

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.domain.model.Character
import com.miltent.featureCharacterCreation.creationNavigator.CharacterCreationNavigationStateHolder
import com.miltent.featureCharacterCreation.fightingStyle.event.FightingStyleEvent
import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleViewState
import javax.inject.Inject

internal class FightingStyleIntentHandler @Inject constructor(
    private val eventHandler: EventHandler<FightingStyleEvent>,
    private val characterCreationNavigationStateHolder: CharacterCreationNavigationStateHolder,
    private val characterCreationBuilder: Character.Builder1stLevel,
    private val viewStateProvider: ViewStateProvider<FightingStyleViewState>
) : IntentHandler<FightingStyleIntent> {

    override suspend fun handle(intent: FightingStyleIntent) = when (intent) {
        is FightingStyleIntent.OnFightingStyleChosen -> Unit
        is FightingStyleIntent.OnNextClicked -> onNextClicked()
    }

    private suspend fun onNextClicked() {
        characterCreationBuilder.specialAbility(viewStateProvider.viewState.value.uiState.currentFightingStyle)
        eventHandler.emitEvent(
            FightingStyleEvent.NextStep(
                characterCreationRoute = requireNotNull(
                    characterCreationNavigationStateHolder.provideNextCharacterCreationStep()
                )
            )
        )
    }
}