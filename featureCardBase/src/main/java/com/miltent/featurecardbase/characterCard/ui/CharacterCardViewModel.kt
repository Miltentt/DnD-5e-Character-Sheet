package com.miltent.featurecardbase.characterCard.ui

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.Intent
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.viewmodel.BaseViewModel
import com.miltent.featurecardbase.characterCard.di.CharacterCard
import com.miltent.featurecardbase.characterCard.event.CharacterCardEvent
import com.miltent.featurecardbase.characterCard.intent.CharacterCardIntent
import com.miltent.featurecardbase.characterCard.state.CharacterCardViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterCardViewModel @Inject constructor(
    @CharacterCard private val viewmodelScope: CoroutineScope,
    private val intentHandler: IntentHandler<CharacterCardIntent>,
    eventHandler: EventHandler<CharacterCardEvent>,
    viewStateProvider: ViewStateProvider<CharacterCardViewState>,
) : BaseViewModel<CharacterCardViewState>(viewmodelScope) {

    override val event: SharedFlow<CharacterCardEvent> = eventHandler.event
    override val viewState: StateFlow<CharacterCardViewState> = viewStateProvider.viewState


    override fun setIntent(intent: Intent) {
        viewmodelScope.launch {
            intentHandler.handle(intent as CharacterCardIntent)
        }
    }
}