package com.miltent.featuredashboard.ui

import androidx.lifecycle.viewModelScope
import com.miltent.core.event.EventHandler
import com.miltent.core.intent.Intent
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.useCase.GetDashBoardCharactersUseCase
import com.miltent.core.viewmodel.BaseViewModel
import com.miltent.domain.model.DashboardCharacter
import com.miltent.featuredashboard.di.Dashboard
import com.miltent.featuredashboard.event.DashboardEvent
import com.miltent.featuredashboard.intent.DashboardIntent
import com.miltent.featuredashboard.state.DashboardViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DashboardViewModel @Inject constructor(
    @Dashboard private val viewmodelScope: CoroutineScope,
    private val intentHandler: IntentHandler<DashboardIntent>,
    eventHandler: EventHandler<DashboardEvent>,
    viewStateProvider: ViewStateProvider<DashboardViewState>,
) : BaseViewModel<DashboardViewState>(viewmodelScope) {

    override val event: SharedFlow<DashboardEvent> = eventHandler.event

    override val viewState: StateFlow<DashboardViewState> = viewStateProvider.viewState

    override fun setIntent(intent: Intent) {
        viewmodelScope.launch {
            intentHandler.handle(intent as DashboardIntent)
        }
    }
}