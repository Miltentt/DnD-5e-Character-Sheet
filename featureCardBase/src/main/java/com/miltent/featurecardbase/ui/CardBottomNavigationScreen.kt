package com.miltent.featurecardbase.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.miltent.featurecardbase.characterCard.CharacterCardRoute
import com.miltent.featurecardbase.characterCard.CharacterCardScreen
import com.miltent.featurecardbase.characterEquipment.CharacterEquipmentRoute
import com.miltent.featurecardbase.characterEquipment.CharacterEquipmentScreen
import com.miltent.featurecardbase.characterSkills.CharacterSkillsRoute
import com.miltent.featurecardbase.characterSkills.CharacterSkillsScreen
import com.miltent.featurecardbase.navigation.CardBaseRoute
import com.miltent.resources.R as ResR

data class BottomNavigationItem(
    val title: String,
    val route: CardBaseRoute,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)


@Composable
fun CardBottomNavigationScreen() {
    val innerNavController = rememberNavController()
    val navBackStackEntry = innerNavController.currentBackStackEntryAsState()
    val currentDestinationRoute = navBackStackEntry.value?.destination?.route

    val items = listOf(
        BottomNavigationItem(
            title = stringResource(ResR.string.skills),
            route = CharacterSkillsRoute,
            selectedIcon = Icons.Filled.Star,
            unselectedIcon = Icons.Outlined.Star
        ),
        BottomNavigationItem(
            title = stringResource(ResR.string.card),
            route = CharacterCardRoute,
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person
        ),
        BottomNavigationItem(
            title = stringResource(ResR.string.equipment),
            route = CharacterEquipmentRoute,
            selectedIcon = Icons.Filled.Build,
            unselectedIcon = Icons.Outlined.Build
        )
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = item.route::class.qualifiedName == currentDestinationRoute,
                        onClick = {
                            innerNavController.navigate(item.route){
                                popUpTo(innerNavController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        },
                        label = { Text(text = item.title) },
                        icon = {
                                Icon(
                                    imageVector =
                                        if (item.route::class.qualifiedName == currentDestinationRoute) item.selectedIcon
                                        else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = innerNavController,
            startDestination = CharacterCardRoute,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<CharacterCardRoute> { CharacterCardScreen() }
            composable<CharacterSkillsRoute> { CharacterSkillsScreen() }
            composable<CharacterEquipmentRoute> { CharacterEquipmentScreen() }
        }
    }
}