package com.miltent.featureCharacterCreation.factory

import com.miltent.core.characterprogression.CharacterProgression
import com.miltent.featureCharacterCreation.baseInfo.navigation.BaseInfoRoute
import com.miltent.featureCharacterCreation.fightingStyle.navigation.FightingStyleRoute
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute
import com.miltent.featureCharacterCreation.skills.navigation.SkillsRoute
import javax.inject.Inject

class CharacterCreationRouteMapperImpl @Inject constructor(): CharacterCreationRouteMapper {
    override fun mapRoute(characterProgression: CharacterProgression): CharacterCreationRoute =
        when(characterProgression) {
            CharacterProgression.BaseInfo -> BaseInfoRoute
            CharacterProgression.Skills -> SkillsRoute
            CharacterProgression.FightingStyle -> FightingStyleRoute
        }
}