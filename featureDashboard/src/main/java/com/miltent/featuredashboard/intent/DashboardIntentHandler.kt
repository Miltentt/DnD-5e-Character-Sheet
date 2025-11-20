package com.miltent.featuredashboard.intent

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.useCase.DeleteCharacterUseCase
import com.miltent.featuredashboard.event.DashboardEvent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
internal class DashboardIntentHandler @Inject internal constructor(
    private val eventHandler: EventHandler<DashboardEvent>,
    private val deleteCharacterUseCase: DeleteCharacterUseCase
): IntentHandler<DashboardIntent> {
    override suspend fun handle(intent: DashboardIntent) = when(intent) {
        is DashboardIntent.OnCharacterCreateClicked -> eventHandler.emitEvent(DashboardEvent.NavigateToCharacterCreation)
        is DashboardIntent.OnCharacterClicked -> eventHandler.emitEvent(DashboardEvent.NavigateToBaseCard(intent.characterId))
        is DashboardIntent.OnCharacterLongClick -> deleteCharacterUseCase.invoke(id = intent.id)
    }
}