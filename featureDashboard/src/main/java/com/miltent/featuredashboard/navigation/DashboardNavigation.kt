package com.miltent.featuredashboard.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.miltent.featuredashboard.event.DashboardEvent
import com.miltent.featuredashboard.ui.DashboardScreen
import kotlinx.serialization.Serializable

@Serializable
data object Dashboard

fun NavGraphBuilder.dashboard(
    navigateToCharacterCreation: () -> Unit,
    navigateToCharacterCard: () -> Unit
) {

    navigation<Dashboard>(
        startDestination = DashboardRoute
    ) {
        composable<DashboardRoute> {
            DashboardScreen(onEvent = { event ->
                when (event) {
                    is DashboardEvent.NavigateToCharacterCreation -> navigateToCharacterCreation()
                    is DashboardEvent.NavigateToBaseCard -> navigateToCharacterCard()
                }
            })
        }
    }
}