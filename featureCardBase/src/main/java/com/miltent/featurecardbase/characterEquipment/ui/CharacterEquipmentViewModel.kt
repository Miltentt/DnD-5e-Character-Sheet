package com.miltent.featurecardbase.characterEquipment.ui

import com.miltent.core.event.Event
import com.miltent.core.intent.Intent
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.viewmodel.BaseViewModel
import com.miltent.featurecardbase.characterEquipment.di.CharacterEquipment
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent
import com.miltent.featurecardbase.characterEquipment.state.CharacterEquipmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterEquipmentViewModel @Inject constructor(
    @CharacterEquipment private val viewModelScope: CoroutineScope,
    viewStateProvider: ViewStateProvider<CharacterEquipmentState>,
    private val intentHandler: IntentHandler<CharacterEquipmentIntent>
) : BaseViewModel<CharacterEquipmentState>(viewModelScope) {

    override val viewState: StateFlow<CharacterEquipmentState> = viewStateProvider.viewState

    override val event: SharedFlow<Event>
        get() = TODO("Not yet implemented")

    override fun setIntent(intent: Intent) {
        viewModelScope.launch {
            intentHandler.handle(intent as CharacterEquipmentIntent)
        }
    }
}