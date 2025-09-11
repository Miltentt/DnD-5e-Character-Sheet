package com.miltent.featureCharacterCreation.creationNavigator

import com.miltent.core.characterprogression.CharacterProgression
import com.miltent.featureCharacterCreation.factory.CharacterCreationRouteMapper
import com.miltent.featureCharacterCreation.navigation.CharacterCreationRoute
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.jvm.Throws

// todo przemyśleć ten navigator
@Singleton
class CharacterCreationNavigationStateHolderImpl @Inject constructor(
    private val characterCreationRouteMapper: CharacterCreationRouteMapper,
) : CharacterCreationNavigationStateHolder {
    private var navigationList: List<CharacterCreationRoute> = emptyList()

    override fun initialize(steps: List<CharacterProgression>) {
        navigationList = steps.map { characterCreationRouteMapper.mapRoute(it) }
    }

    @Throws(CharacterCreationRouteException::class)
    override fun provideNextCharacterCreationStep(currentStep: CharacterProgression): CharacterCreationRoute? {
        val route = characterCreationRouteMapper.mapRoute(currentStep)
        val currentIndex = navigationList.indexOf(route)
        return if (currentIndex != navigationList.lastIndex) {
            navigationList[currentIndex + 1]
        } else {
            throw CharacterCreationRouteException
        }
    }
}

data object CharacterCreationRouteException : Throwable("character creation list out of bounds")