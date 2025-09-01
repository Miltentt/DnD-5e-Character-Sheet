package com.miltent.featureCharacterCreation.skills.intent

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.useCase.InsertCharacterUseCase
import com.miltent.domain.model.Character
import com.miltent.featureCharacterCreation.skills.event.SkillsEvent
import com.miltent.featureCharacterCreation.skills.state.SkillsViewState
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
internal class SkillsIntentHandler @Inject internal constructor(
    private val characterBuilder1stLevel: Character.Builder1stLevel,
    private val viewStateProvider: ViewStateProvider<SkillsViewState>,
    private val eventHandler: EventHandler<SkillsEvent>,
    private val insertCharacterUseCase: InsertCharacterUseCase,
) : IntentHandler<SkillsIntent> {
    override suspend fun handle(intent: SkillsIntent) = when (intent) {
        is SkillsIntent.OnSkillToggled -> Unit
        is SkillsIntent.OnNextClicked -> onNextClicked()
    }

    private suspend fun onNextClicked() {
        characterBuilder1stLevel.skills(viewStateProvider.viewState.value.skillList)
        runCatching {
            insertCharacterUseCase.invoke(characterBuilder1stLevel.build())
        }.onFailure {
            eventHandler.emitEvent(SkillsEvent.NavigateToError)
        }.onSuccess {
            eventHandler.emitEvent(SkillsEvent.FinishProcess)
        }
    }
}