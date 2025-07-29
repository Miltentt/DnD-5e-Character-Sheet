package com.miltent.featureCharacterCreation.di

import com.miltent.featureCharacterCreation.factory.CharacterCreationRouteFactory
import com.miltent.featureCharacterCreation.factory.CharacterCreationRouteFactoryImpl
import com.miltent.featureCharacterCreation.factory.CharacterProgressionFactory
import com.miltent.featureCharacterCreation.factory.CharacterProgressionFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface FactoryModule {

    @Binds
    fun bindCharacterProgressionFactory(factory: CharacterProgressionFactoryImpl): CharacterProgressionFactory

    @Binds
    fun bindCharacterCreationRouteFactory(factory: CharacterCreationRouteFactoryImpl): CharacterCreationRouteFactory
}