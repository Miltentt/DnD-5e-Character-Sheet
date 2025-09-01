package com.miltent.featureCharacterCreation.factory

import com.miltent.core.characterprogression.CharacterProgression
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute

interface CharacterCreationRouteFactory {

    fun mapRoutes(list: List<CharacterProgression>): List<CharacterCreationRoute>
}