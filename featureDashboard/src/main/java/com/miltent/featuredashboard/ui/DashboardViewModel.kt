package com.miltent.featuredashboard.ui

import androidx.compose.runtime.mutableStateOf
import com.miltent.core.event.Event
import com.miltent.core.event.EventHandler
import com.miltent.core.useCase.GetDashBoardCharactersUseCase
import com.miltent.core.viewmodel.BaseViewModel
import com.miltent.domain.model.DashboardCharacter
import com.miltent.featuredashboard.event.DashboardEvent
import com.miltent.featuredashboard.state.DashboardViewState
import com.miltent.featuredashboard.state.DashboardUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class DashboardViewModel(
    private val viewmodelScope: CoroutineScope,
    private val getDashBoardCharactersUseCase: GetDashBoardCharactersUseCase,
    private val eventHandler: EventHandler<DashboardEvent>
) : BaseViewModel<DashboardViewState>(viewmodelScope) {


    private val _viewState: MutableStateFlow<DashboardViewState> = MutableStateFlow(DashboardViewState.Empty)
    override val viewState: StateFlow<DashboardViewState> = _viewState

    init {
        viewmodelScope.launch {
            getDashBoardCharactersUseCase.invoke().collect { dashboardCharacters: List<DashboardCharacter> ->
                _viewState.update { DashboardViewState.Loaded(dashboardCharacters) }
            }
        }

    }

    override fun setEvent(event: Event) {
        eventHandler.handle(event as DashboardEvent)
    }
}