package com.miltent.featureCharacterCreation.skills.ui

import androidx.lifecycle.viewModelScope
import com.miltent.core.event.Event
import com.miltent.core.event.EventHandler
import com.miltent.core.intent.Intent
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.viewmodel.BaseViewModel
import com.miltent.featureCharacterCreation.skills.di.Skills
import com.miltent.featureCharacterCreation.skills.event.SkillsEvent
import com.miltent.featureCharacterCreation.skills.intent.SkillsIntent
import com.miltent.featureCharacterCreation.skills.state.SkillsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SkillsViewModel @Inject constructor(
    @Skills private val viewmodelScope: CoroutineScope,
    private val intentHandler: IntentHandler<SkillsIntent>,
    viewStateProvider: ViewStateProvider<SkillsViewState>,
    eventHandler: EventHandler<SkillsEvent>
) : BaseViewModel<SkillsViewState>(viewmodelScope) {

    override val viewState: StateFlow<SkillsViewState> = viewStateProvider.viewState

    override val event: SharedFlow<Event> = eventHandler.event

    override fun setIntent(intent: Intent) {
        viewmodelScope.launch {
        intentHandler.handle(intent as SkillsIntent)
    }
    }
}