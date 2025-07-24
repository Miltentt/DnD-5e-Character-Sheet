package com.miltent.dnd5echaractersheet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute
import com.miltent.featureCharacterCreation.navigation.characterCreation
import com.miltent.featuredashboard.navigation.Dashboard
import com.miltent.featuredashboard.navigation.dashboard

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Dashboard) {

        dashboard(navigateToCharacterCreation = {
            navController.navigate(CharacterCreationRoute)
        })

        characterCreation()
    }
}