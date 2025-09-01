package com.miltent.featureCharacterCreation.creationNavigator

import com.miltent.core.characterprogression.CharacterProgression
import com.miltent.featureCharacterCreation.factory.CharacterCreationRouteFactory
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute
import javax.inject.Inject
import javax.inject.Singleton

// todo przemyśleć ten navigator
@Singleton
class CharacterCreationNavigationStateHolderImpl @Inject constructor(
    private val characterCreationRouteFactory: CharacterCreationRouteFactory,
) : CharacterCreationNavigationStateHolder {
    private var currentNavStep: Int = 0
    private var navigationList: List<CharacterCreationRoute> = emptyList()

    override fun initialize(steps: List<CharacterProgression>) {
        navigationList = characterCreationRouteFactory.mapRoutes(steps)
    }

    override fun provideNextCharacterCreationStep(): CharacterCreationRoute? {
        return if (currentNavStep < navigationList.size) {
            navigationList[currentNavStep].also { currentNavStep++ }
        } else {
            null
        }
    }
}