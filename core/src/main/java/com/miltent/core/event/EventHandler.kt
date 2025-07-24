package com.miltent.core.event

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

abstract class EventHandler<T: Event> {

    private val _event: MutableSharedFlow<T> = MutableSharedFlow()
    val event: SharedFlow<T> = _event

    fun emitEvent(event: T) { this._event.tryEmit(event) }
}