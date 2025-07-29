package com.miltent.featureCharacterCreation.creationNavigator

import com.miltent.domain.model.CharacterProgression
import com.miltent.featureCharacterCreation.factory.CharacterCreationRouteFactory
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute
import javax.inject.Inject
import javax.inject.Singleton

// todo przemyśleć ten navigator
@Singleton
class CharacterCreationNavigationStateHolderImpl @Inject constructor(
     private val characterCreationRouteFactory: CharacterCreationRouteFactory,
): CharacterCreationNavigationStateHolder {
    private var currentNavStep: Int = 0
    private var navigationList: List<CharacterCreationRoute>? = null

    override fun initialize(steps: List<CharacterProgression>) {
        navigationList = characterCreationRouteFactory.mapRoutes(steps)
    }

    override fun provideNextCharacterCreationStep(): CharacterCreationRoute? {
      return try {
            navigationList?.get(currentNavStep)
        } catch (e: Exception) {
            // TODO
            null
        } finally {
            currentNavStep++
        }
    }
}