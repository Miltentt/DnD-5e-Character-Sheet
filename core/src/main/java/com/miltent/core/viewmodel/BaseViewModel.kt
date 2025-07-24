package com.miltent.core.viewmodel

import androidx.lifecycle.ViewModel
import com.miltent.core.event.Event
import com.miltent.core.intent.Intent
import com.miltent.core.ui.ViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<T : ViewState>(private val viewModelScope: CoroutineScope) :
    ViewModel() {

    abstract val viewState: StateFlow<T>

    abstract val event: SharedFlow<Event>

    abstract fun setIntent(intent: Intent)

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}