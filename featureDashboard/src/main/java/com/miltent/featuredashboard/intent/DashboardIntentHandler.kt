package com.miltent.featuredashboard.intent

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.featuredashboard.di.Dashboard
import com.miltent.featuredashboard.event.DashboardEvent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
@ViewModelScoped
internal class DashboardIntentHandler @Inject internal constructor(
    private val eventHandler: EventHandler<DashboardEvent>,
): IntentHandler<DashboardIntent> {
    override suspend fun handle(intent: DashboardIntent) = when(intent) {
        is DashboardIntent.OnCharacterCreateClicked -> eventHandler.emitEvent(DashboardEvent.NavigateToCharacterCreation)
    }
}