package com.miltent.featureCharacterCreation.factory

import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.CharacterProgression
import com.miltent.domain.model.Race
import javax.inject.Inject

class CharacterProgressionFactoryImpl @Inject constructor() : CharacterProgressionFactory {

    override fun create(race: Race, characterClass: CharacterClass): List<CharacterProgression> =
        (race.characterCreationProgression + characterClass.characterCreationProgression + CharacterProgression.Skills).reversed()
}