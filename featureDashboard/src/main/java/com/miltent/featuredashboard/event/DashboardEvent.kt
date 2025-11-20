package com.miltent.featuredashboard.event

import com.miltent.core.event.Event

internal sealed interface DashboardEvent: Event {
    data object NavigateToCharacterCreation: DashboardEvent
    data class NavigateToBaseCard(val characterId: String): DashboardEvent
}