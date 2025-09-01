package com.miltent.database.di

import com.miltent.database.factory.CharacterClassDbToDomainFactory
import com.miltent.database.factory.CharacterClassDbToDomainFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface FactoryModule {

    @Binds
    fun bindCharacterClassDomainFactory(
        characterClassDomainFactory: CharacterClassDbToDomainFactoryImpl
    ): CharacterClassDbToDomainFactory

}