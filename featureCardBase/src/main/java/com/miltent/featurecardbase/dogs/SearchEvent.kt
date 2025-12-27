package com.miltent.featurecardbase.dogs

import com.miltent.core.event.Event

sealed interface SearchEvent: Event {
    data class DogsSearch(val success: Boolean): SearchEvent
    data class NetworkingError(val code: String?): SearchEvent
}