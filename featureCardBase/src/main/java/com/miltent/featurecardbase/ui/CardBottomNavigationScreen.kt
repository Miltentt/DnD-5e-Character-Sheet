package com.miltent.featurecardbase.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miltent.featurecardbase.characterCard.CharacterCardRoute
import com.miltent.featurecardbase.characterCard.ui.CharacterCardScreen
import com.miltent.featurecardbase.characterEquipment.CharacterEquipmentRoute
import com.miltent.featurecardbase.characterEquipment.CharacterEquipmentScreen
import com.miltent.featurecardbase.characterSkills.CharacterSkillsRoute
import com.miltent.featurecardbase.characterSkills.CharacterSkillsScreen
import com.miltent.featurecardbase.dogs.DogsRoute
import com.miltent.featurecardbase.dogs.DogsScreen
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
    var currentDestinationRoute: CardBaseRoute by remember { mutableStateOf(CharacterCardRoute) }

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
        ),
        BottomNavigationItem(
            title = "Dogs",
            route = DogsRoute,
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info
        )
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = item.route == currentDestinationRoute,
                        onClick = {
                            currentDestinationRoute = item.route
                            innerNavController.navigate(item.route){
                                popUpTo(0)
                            }
                        },                                        
                        label = { Text(text = item.title) },      
                        icon = {                                  
                                Icon(                             
                                    imageVector =
                                    if (item.route == currentDestinationRoute) item.selectedIcon
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
            composable<DogsRoute> { DogsScreen() }
        }
    }
}