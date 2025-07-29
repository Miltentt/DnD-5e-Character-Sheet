package com.miltent.core.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.miltent.core.event.Event
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

@Composable
fun <T : Event> ObserveEvents(events: SharedFlow<T>, onEvent: (T) -> Unit) {
    LaunchedEffect(events) {
        launch {
            events.collect { event ->
                onEvent(event)
            }
        }
    }
}
