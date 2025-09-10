package com.miltent.featureCharacterCreation.fightingStyle.ui

import com.miltent.core.event.Event
import com.miltent.core.event.EventHandler
import com.miltent.core.intent.Intent
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.viewmodel.BaseViewModel
import com.miltent.featureCharacterCreation.fightingStyle.di.FightingStyle
import com.miltent.featureCharacterCreation.fightingStyle.event.FightingStyleEvent
import com.miltent.featureCharacterCreation.fightingStyle.intent.FightingStyleIntent
import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FightingStyleViewModel @Inject constructor(
    @FightingStyle private val viewmodelScope: CoroutineScope,
    private val intentHandler: IntentHandler<FightingStyleIntent>,
    viewStateProvider: ViewStateProvider<FightingStyleViewState>,
    eventHandler: EventHandler<FightingStyleEvent>
) : BaseViewModel<FightingStyleViewState>(viewmodelScope) {

    override val viewState: StateFlow<FightingStyleViewState> = viewStateProvider.viewState

    override val event: SharedFlow<FightingStyleEvent> = eventHandler.event

    override fun setIntent(intent: Intent) {
        viewmodelScope.launch {
            intentHandler.handle(intent as FightingStyleIntent)
        }
    }
}