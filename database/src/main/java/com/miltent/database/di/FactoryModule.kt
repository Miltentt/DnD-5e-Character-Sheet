package com.miltent.database.di

import com.miltent.database.factory.dbToDomain.CharacterClassDbToDomainFactory
import com.miltent.database.factory.dbToDomain.CharacterClassDbToDomainFactoryImpl
import com.miltent.database.factory.dbToDomain.CharacterDetailedFactory
import com.miltent.database.factory.dbToDomain.CharacterDetailedFactoryImpl
import com.miltent.database.factory.dbToDomain.SkillDbToDomainFactory
import com.miltent.database.factory.dbToDomain.SkillDbToDomainFactoryImpl
import com.miltent.database.factory.dbToDomain.SpecialAbilityDbToDomainFactory
import com.miltent.database.factory.dbToDomain.SpecialAbilityDbToDomainFactoryImpl
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

    @Binds
    fun bindCharacterDetailedFactory(factoryImpl: CharacterDetailedFactoryImpl): CharacterDetailedFactory

    @Binds
    fun bindSkillsDbToDomainFactory(factoryImpl: SkillDbToDomainFactoryImpl): SkillDbToDomainFactory

    @Binds
    fun bindSpecialAbilityDbToDomainFactory(factoryImpl: SpecialAbilityDbToDomainFactoryImpl): SpecialAbilityDbToDomainFactory

}