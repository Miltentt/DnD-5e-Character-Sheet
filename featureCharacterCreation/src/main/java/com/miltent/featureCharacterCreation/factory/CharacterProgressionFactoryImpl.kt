package com.miltent.featureCharacterCreation.factory

import com.miltent.core.characterprogression.CharacterProgression
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import javax.inject.Inject

class CharacterProgressionFactoryImpl @Inject constructor() : CharacterProgressionFactory {

    override fun create(race: Race, characterClass: CharacterClass): List<CharacterProgression> =

        (listOf(CharacterProgression.Skills) + getRaceSteps(race) + getCharacterClassSteps(characterClass) ).reversed()

    private fun getRaceSteps(race: Race): List<CharacterProgression> = when (race) {
        Race.Dwarf -> listOf()
    }

    private fun getCharacterClassSteps(characterClass: CharacterClass): List<CharacterProgression> = when (characterClass) {
       is CharacterClass.Fighter -> listOf(CharacterProgression.FightingStyle)
    }
}