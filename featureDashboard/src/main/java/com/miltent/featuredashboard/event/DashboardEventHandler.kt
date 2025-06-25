package com.miltent.featuredashboard.event

import com.miltent.core.event.EventHandler

class DashboardEventHandler: EventHandler<DashboardEvent> {
    override fun handle(event: DashboardEvent) = when(event) {
        is DashboardEvent.OnCharacterCreateClicked -> Unit
    }
}