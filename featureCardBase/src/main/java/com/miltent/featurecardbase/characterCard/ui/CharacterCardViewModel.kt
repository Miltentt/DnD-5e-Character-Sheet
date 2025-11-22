package com.miltent.featurecardbase.characterCard.ui

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.Intent
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.viewmodel.BaseViewModel
import com.miltent.featurecardbase.characterCard.state.CharacterCardViewState
import com.miltent.featurecardbase.di.CardBase
import com.miltent.featurecardbase.event.CardBaseEvent
import com.miltent.featurecardbase.intent.CardBaseIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterCardViewModel @Inject constructor(
    @CardBase private val viewmodelScope: CoroutineScope,
    private val intentHandler: IntentHandler<CardBaseIntent>,
    eventHandler: EventHandler<CardBaseEvent>,
    viewStateProvider: ViewStateProvider<CharacterCardViewState>,
) : BaseViewModel<CharacterCardViewState>(viewmodelScope) {

    override val event: SharedFlow<CardBaseEvent> = eventHandler.event
    override val viewState: StateFlow<CharacterCardViewState> = viewStateProvider.viewState


    override fun setIntent(intent: Intent) {
        viewmodelScope.launch {
            intentHandler.handle(intent as CardBaseIntent)
        }
    }
}