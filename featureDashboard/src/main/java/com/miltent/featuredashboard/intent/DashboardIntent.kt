package com.miltent.featuredashboard.intent

import com.miltent.core.intent.Intent

sealed interface DashboardIntent: Intent {

    data object OnCharacterCreateClicked: DashboardIntent
    data class OnCharacterClicked(val name: String): DashboardIntent
    data class OnCharacterDeleteClicked(val id: String): DashboardIntent
    data class OnChoosingCharacterToDelete(val id: String?): DashboardIntent
}