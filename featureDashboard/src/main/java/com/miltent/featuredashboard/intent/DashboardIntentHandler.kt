package com.miltent.featuredashboard.intent

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.useCase.DeleteCharacterUseCase
import com.miltent.featuredashboard.event.DashboardEvent
import com.miltent.featuredashboard.state.DashboardUiState
import com.miltent.featuredashboard.state.DashboardViewState
import com.miltent.featuredashboard.state.provider.DashboardViewStateProvider
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
@ViewModelScoped
internal class DashboardIntentHandler @Inject internal constructor(
    private val viewStateProvider: DashboardViewStateProvider,
    private val eventHandler: EventHandler<DashboardEvent>,
    private val deleteCharacterUseCase: DeleteCharacterUseCase
): IntentHandler<DashboardIntent> {
    override suspend fun handle(intent: DashboardIntent) = when(intent) {
        is DashboardIntent.OnCharacterCreateClicked -> eventHandler.emitEvent(DashboardEvent.NavigateToCharacterCreation)
        is DashboardIntent.OnCharacterClicked -> eventHandler.emitEvent(DashboardEvent.NavigateToBaseCard(intent.name))
        is DashboardIntent.OnCharacterDeleteClicked -> deleteCharacterUseCase.invoke(id = intent.id)
        is DashboardIntent.OnChoosingCharacterToDelete ->
            viewStateProvider.updateState(
                (viewStateProvider.viewState.value as DashboardViewState.Loaded).copy(
                    uiState = DashboardUiState(intent.id)
                )
            )
    }
}