package com.miltent.featureCharacterCreation.di

import com.miltent.featureCharacterCreation.factory.CharacterCreationRouteMapper
import com.miltent.featureCharacterCreation.factory.CharacterCreationRouteMapperImpl
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
    fun bindCharacterCreationRouteFactory(factory: CharacterCreationRouteMapperImpl): CharacterCreationRouteMapper
}