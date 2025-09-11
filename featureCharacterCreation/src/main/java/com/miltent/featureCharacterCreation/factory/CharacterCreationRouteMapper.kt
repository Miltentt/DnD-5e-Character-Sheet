package com.miltent.featureCharacterCreation.factory

import com.miltent.core.characterprogression.CharacterProgression
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute

interface CharacterCreationRouteMapper {

    fun mapRoute(characterProgression: CharacterProgression): CharacterCreationRoute
}