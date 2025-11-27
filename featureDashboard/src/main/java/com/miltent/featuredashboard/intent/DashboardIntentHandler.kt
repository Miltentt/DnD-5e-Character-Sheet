package com.miltent.featuredashboard.intent

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.useCase.DeleteCharacterUseCase
import com.miltent.featuredashboard.event.DashboardEvent
import com.miltent.featuredashboard.state.DashboardUiState
import com.miltent.featuredashboard.state.DashboardViewState
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
@ViewModelScoped
internal class DashboardIntentHandler @Inject internal constructor(
    private val viewStateProvider: ViewStateProvider<DashboardViewState>,
    private val eventHandler: EventHandler<DashboardEvent>,
    private val deleteCharacterUseCase: DeleteCharacterUseCase
): IntentHandler<DashboardIntent> {
    override suspend fun handle(intent: DashboardIntent) = when(intent) {
        is DashboardIntent.OnCharacterCreateClicked -> eventHandler.emitEvent(DashboardEvent.NavigateToCharacterCreation)
        is DashboardIntent.OnCharacterClicked -> eventHandler.emitEvent(DashboardEvent.NavigateToBaseCard(intent.name))
        is DashboardIntent.OnCharacterDeleteClicked -> deleteCharacterUseCase.invoke(id = intent.id)
        is DashboardIntent.OnChoosingCharacterToDelete ->
            viewStateProvider.updateState(
                viewStateProvider.viewState.value.copy(
                    uiState = DashboardUiState(intent.id)
                )
            )
    }
}