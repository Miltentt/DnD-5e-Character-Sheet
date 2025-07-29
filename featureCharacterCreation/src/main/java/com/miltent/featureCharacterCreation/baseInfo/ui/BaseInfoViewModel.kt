package com.miltent.featureCharacterCreation.baseInfo.ui

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.Intent
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.viewmodel.BaseViewModel
import com.miltent.featureCharacterCreation.baseInfo.di.BaseInfo
import com.miltent.featureCharacterCreation.baseInfo.event.BaseInfoEvent
import com.miltent.featureCharacterCreation.baseInfo.intent.BaseInfoIntent
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BaseInfoViewModel @Inject constructor(
    @BaseInfo private val viewModelScope: CoroutineScope,
    private val intentHandler: IntentHandler<BaseInfoIntent>,
    viewStateProvider: ViewStateProvider<BaseInfoViewState>,
    eventHandler: EventHandler<BaseInfoEvent>
) : BaseViewModel<BaseInfoViewState>(viewModelScope) {

    override val viewState: StateFlow<BaseInfoViewState> = viewStateProvider.viewState

    override val event: SharedFlow<BaseInfoEvent> = eventHandler.event

    override fun setIntent(intent: Intent) {
        viewModelScope.launch {
            intentHandler.handle(intent as BaseInfoIntent)
        }
    }
}