package com.miltent.featureCharacterCreation.di

import com.miltent.domain.model.Character
import com.miltent.featureCharacterCreation.builder.Character1stLevelBuilderImpl
import com.miltent.featureCharacterCreation.creationNavigator.CharacterCreationNavigationStateHolder
import com.miltent.featureCharacterCreation.creationNavigator.CharacterCreationNavigationStateHolderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CharacterCreationModule {

    @Binds
    fun bindCharacterCreationNavigationStateHolder(holder: CharacterCreationNavigationStateHolderImpl): CharacterCreationNavigationStateHolder

    @Binds
    fun bindCharacter1stLevelBuilder(builder: Character1stLevelBuilderImpl): Character.Builder1stLevel
}