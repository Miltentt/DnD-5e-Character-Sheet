package com.miltent.featuredashboard.event

import com.miltent.core.event.Event

sealed interface DashboardEvent: Event {

    data object OnCharacterCreateClicked: DashboardEvent
}