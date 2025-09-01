package com.miltent.featureCharacterCreation.creationNavigator

import com.miltent.core.characterprogression.CharacterProgression
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute

interface CharacterCreationNavigationStateHolder {

    fun initialize(steps: List<CharacterProgression>)

    fun provideNextCharacterCreationStep(): CharacterCreationRoute?
}