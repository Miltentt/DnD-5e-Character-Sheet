package com.miltent.featureCharacterCreation.creationNavigator

import com.miltent.domain.model.CharacterProgression
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute

interface CharacterCreationNavigationStateHolder {

    fun initialize(steps: List<CharacterProgression>)

    fun provideNextCharacterCreationStep(): CharacterCreationRoute?
}