package com.miltent.featurecardbase.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.miltent.featurecardbase.ui.CardBottomNavigationScreen

fun NavGraphBuilder.cardBase() {

        composable<CardBottomNavigationRoute> {
                val args = it.toRoute<CardBottomNavigationRoute>()
                CardBottomNavigationScreen(args.characterId)
        }
}