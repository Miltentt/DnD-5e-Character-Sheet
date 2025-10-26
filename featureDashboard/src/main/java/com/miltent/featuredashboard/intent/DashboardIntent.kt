package com.miltent.featuredashboard.intent

import com.miltent.core.intent.Intent

sealed interface DashboardIntent: Intent {

    data object OnCharacterCreateClicked: DashboardIntent
    data object OnCharacterClicked: DashboardIntent
}