package com.miltent.featuredashboard.intent

import com.miltent.core.intent.Intent

sealed interface DashboardIntent: Intent {

    data object OnCharacterCreateClicked: DashboardIntent
    data class OnCharacterClicked(val characterId: String): DashboardIntent
    data class OnCharacterLongClick(val id: String): DashboardIntent
}