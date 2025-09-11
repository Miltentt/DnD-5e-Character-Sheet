package com.miltent.featureCharacterCreation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.miltent.domain.model.Skill
import com.miltent.featureCharacterCreation.baseInfo.event.BaseInfoEvent
import com.miltent.featureCharacterCreation.baseInfo.navigation.BaseInfoRoute
import com.miltent.featureCharacterCreation.baseInfo.ui.BaseInfoScreen
import com.miltent.featureCharacterCreation.fightingStyle.di.FightingStyle
import com.miltent.featureCharacterCreation.fightingStyle.event.FightingStyleEvent
import com.miltent.featureCharacterCreation.fightingStyle.navigation.FightingStyleRoute
import com.miltent.featureCharacterCreation.fightingStyle.ui.FightingStyleScreen
import com.miltent.featureCharacterCreation.skills.event.SkillsEvent
import com.miltent.featureCharacterCreation.skills.navigation.SkillsRoute
import com.miltent.featureCharacterCreation.skills.ui.SkillsScreen
import kotlinx.serialization.Serializable

@Serializable
object CharacterCreationNavigation

interface CharacterCreationRoute

fun NavGraphBuilder.characterCreation(navController: NavController) {

    navigation<CharacterCreationNavigation>(
        startDestination = BaseInfoRoute
    ) {

        composable<BaseInfoRoute> {
            BaseInfoScreen(onEvent = {
                when (it) {
                    is BaseInfoEvent.NextStep -> navController.navigate(it.nextStepRoute)
                }
            })
        }

        composable<SkillsRoute> {
            SkillsScreen(onEvent = {
                when (it) {
                    is SkillsEvent.FinishProcess ->  {
                         navController.popBackStack(BaseInfoRoute, inclusive = true)
                    }
                    is SkillsEvent.NavigateToError -> {

                    }
                }
            })
        }

        composable<FightingStyleRoute> {
            FightingStyleScreen(onEvent = {
                when (it) {
                    is FightingStyleEvent.NextStep -> navController.navigate(it.nextStepRoute)
                }
            })
        }
    }
}