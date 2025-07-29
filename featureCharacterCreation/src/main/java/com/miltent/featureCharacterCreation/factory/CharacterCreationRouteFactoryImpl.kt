package com.miltent.featureCharacterCreation.factory

import com.miltent.domain.model.CharacterProgression
import com.miltent.featureCharacterCreation.fightingStyle.navigation.FightingStyleRoute
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute
import com.miltent.featureCharacterCreation.skills.navigation.SkillsRoute
import javax.inject.Inject

class CharacterCreationRouteFactoryImpl @Inject constructor(): CharacterCreationRouteFactory {
    override fun mapRoutes(list: List<CharacterProgression>): List<CharacterCreationRoute> = list.map {
        when(it) {
            CharacterProgression.Feats -> SkillsRoute
            CharacterProgression.Skills -> SkillsRoute
            CharacterProgression.FightingStyle -> FightingStyleRoute
        }
    }
}