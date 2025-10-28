package com.miltent.featurecardbase.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.miltent.featurecardbase.ui.CardBottomNavigationScreen

fun NavGraphBuilder.cardBase() {
        composable<CardBottomNavigationRoute> { CardBottomNavigationScreen() }
}