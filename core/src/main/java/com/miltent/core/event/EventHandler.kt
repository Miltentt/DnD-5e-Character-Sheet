package com.miltent.core.event

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

abstract class EventHandler<T: Event> {

    private val _event: MutableSharedFlow<T> = MutableSharedFlow()
    val event: SharedFlow<T> get() = _event

    suspend fun emitEvent(event: T) {
        this._event.emit(event)
    }
}