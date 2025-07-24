package com.miltent.featuredashboard.intent

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.featuredashboard.event.DashboardEvent
import javax.inject.Inject

internal class DashboardIntentHandler @Inject internal constructor(
    private val eventHandler: EventHandler<DashboardEvent>,
): IntentHandler<DashboardIntent> {
    override fun handle(intent: DashboardIntent) = when(intent) {
        is DashboardIntent.OnCharacterCreateClicked -> eventHandler.emitEvent(DashboardEvent.NavigateToCharacterCreation)
    }
}