package com.miltent.database.di

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.AttributeEntity
import com.miltent.database.entities.CharacterClassEntity
import com.miltent.database.entities.CharacterEntity
import com.miltent.database.entities.MovementSpeedEntity
import com.miltent.database.entities.RaceEntity
import com.miltent.database.entities.SpecialAbilityEntity
import com.miltent.database.mapper.DbToDomain.AttributeDbToDomainMapper
import com.miltent.database.mapper.DbToDomain.CharacterDbToDomainMapper
import com.miltent.database.mapper.DbToDomain.MovementSpeedDbToDomainMapper
import com.miltent.database.mapper.DbToDomain.RaceDbToDomainMapper
import com.miltent.database.mapper.DbToDomain.SpecialAbilityDbToDomainMapper
import com.miltent.database.mapper.domainToDb.AttributesDomainToDbMapper
import com.miltent.database.mapper.domainToDb.CharacterClassDomainToDbMapper
import com.miltent.database.mapper.domainToDb.CharacterDomainToEntityMapper
import com.miltent.database.mapper.domainToDb.MovementSpeedDomainToDbMapper
import com.miltent.database.mapper.domainToDb.RaceDomainToDbMapper
import com.miltent.database.mapper.domainToDb.SpecialAbilityDomainToDbMapper
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.Race
import com.miltent.domain.model.SpecialAbility
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
    fun bindAttributeDomainToEntityMapper(
        attributesDomainToEntityMapper: AttributesDomainToDbMapper
    ): Mapper<Attribute, AttributeEntity>

    @Binds
    fun bindAttributeEntityToDomainMapper(
        attributesEntityToDomainMapper: AttributeDbToDomainMapper
    ): Mapper<AttributeEntity, Attribute>

    @Binds
    fun bindMovementSpeedDomainToEntityMapper(
        movementSpeedDomainToDbMapper: MovementSpeedDomainToDbMapper
    ): Mapper<MovementSpeed, MovementSpeedEntity>

    @Binds
    fun bindMovementSpeedEntityToDomainMapper(
        movementSpeedDbToDomainMapper: MovementSpeedDbToDomainMapper): Mapper<MovementSpeedEntity, MovementSpeed>

   @Binds
   fun bindRaceDbToDomainMapper(
       raceEntityToDomainMapper: RaceDbToDomainMapper
   ): Mapper<RaceEntity, Race>

   @Binds
   fun bindRaceDomainToEntityMapper(
       raceDomainToEntityMapper: RaceDomainToDbMapper
   ): Mapper<Race, RaceEntity>

   @Binds
   fun bindSpecialAbilityDomainToEntityMapper(
       specialAbilityDomainToEntityMapper: SpecialAbilityDomainToDbMapper
   ): Mapper<SpecialAbility, SpecialAbilityEntity>

   @Binds
   fun bindSpecialAbilityEntityToDomainMapper(
       specialAbilityEntityToDomainMapper: SpecialAbilityDbToDomainMapper
   ): Mapper<SpecialAbilityEntity, SpecialAbility>

}