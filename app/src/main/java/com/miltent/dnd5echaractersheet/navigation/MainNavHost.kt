package com.miltent.dnd5echaractersheet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.miltent.featureCharacterCreation.navigation.CharacterCreationNavigation
import com.miltent.featureCharacterCreation.navigation.characterCreation
import com.miltent.featurecardbase.navigation.CardBottomNavigationRoute
import com.miltent.featuredashboard.navigation.Dashboard
import com.miltent.featuredashboard.navigation.dashboard
import com.miltent.featurecardbase.navigation.cardBase
// TODO rethink navigation
@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Dashboard) {

        dashboard(
            navigateToCharacterCreation = {
                navController.navigate(CharacterCreationNavigation)
            },
            navigateToCharacterCard = { name ->
                navController.navigate(CardBottomNavigationRoute(name))
            }
        )
        characterCreation(navController = navController)
        cardBase()
    }
}