package com.miltent.featureCharacterCreation.di

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
}