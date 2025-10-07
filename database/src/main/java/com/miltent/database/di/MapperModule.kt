package com.miltent.database.di

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.character.CharacterClassEntity
import com.miltent.database.entities.character.CharacterEntity
import com.miltent.database.entities.character.RaceEntity
import com.miltent.database.mapper.dbToDomain.CharacterDbToDomainMapper
import com.miltent.database.mapper.dbToDomain.RaceDbToDomainMapper
import com.miltent.database.mapper.domainToDb.CharacterClassDomainToDbMapper
import com.miltent.database.mapper.domainToDb.CharacterDomainToEntityMapper
import com.miltent.database.mapper.domainToDb.RaceDomainToDbMapper
import com.miltent.domain.model.Character
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MapperModule {

    @Binds
    fun bindCharacterDomainToEntityMapper(
        characterDomainToEntityMapper: CharacterDomainToEntityMapper
    ): Mapper<Character, CharacterEntity>

    @Binds
    fun bindCharacterEntityToDomainMapper(
        characterEntityToDomainMapper: CharacterDbToDomainMapper
    ): Mapper<CharacterEntity, Character>

    @Binds
    fun bindCharacterClassDomainToEntityMapper(
        characterClassDomainToEntityMapper: CharacterClassDomainToDbMapper
    ): Mapper<CharacterClass, CharacterClassEntity>

    @Binds
    fun bindRaceDbToDomainMapper(
        raceEntityToDomainMapper: RaceDbToDomainMapper
    ): Mapper<RaceEntity, Race>

    @Binds
    fun bindRaceDomainToEntityMapper(
        raceDomainToEntityMapper: RaceDomainToDbMapper
    ): Mapper<Race, RaceEntity>
}