package com.miltent.featureCharacterCreation.factory

import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.CharacterProgression
import com.miltent.domain.model.Race

interface CharacterProgressionFactory {

    fun create(race: Race, characterClass: CharacterClass): List<CharacterProgression>
}