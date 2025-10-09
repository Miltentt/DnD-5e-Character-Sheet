package com.miltent.featureCharacterCreation.factory

import com.miltent.core.characterprogression.CharacterProgression
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.featureCharacterCreation.baseInfo.navigation.BaseInfoRoute
import javax.inject.Inject

class CharacterProgressionFactoryImpl @Inject constructor() : CharacterProgressionFactory {

    override fun create(race: Race, characterClass: CharacterClass): List<CharacterProgression> =

        (listOf(CharacterProgression.BaseInfo) + getRaceSteps(race) + getCharacterClassSteps(
            characterClass
        ) + CharacterProgression.Skills)

    private fun getRaceSteps(race: Race): List<CharacterProgression> = when (race) {
        Race.Dwarf -> listOf()
        Race.Drow -> listOf()
    }

    private fun getCharacterClassSteps(characterClass: CharacterClass): List<CharacterProgression> =
        when (characterClass) {
            is CharacterClass.Fighter -> listOf(CharacterProgression.FightingStyle)
            is CharacterClass.Ranger -> listOf(CharacterProgression.FightingStyle)
        }
}