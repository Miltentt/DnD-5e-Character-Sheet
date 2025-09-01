package com.miltent.database.mapper.DbToDomain

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.AttributeEntity
import com.miltent.database.entities.CharacterEntity
import com.miltent.database.entities.MovementSpeedEntity
import com.miltent.database.entities.RaceEntity
import com.miltent.database.factory.CharacterClassDbToDomainFactory
import com.miltent.domain.model.Attribute
import javax.inject.Inject
import com.miltent.domain.model.Character
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.Race

class CharacterDbToDomainMapper @Inject constructor(
    private val raceDbToDomainMapper: Mapper<RaceEntity, Race>,
    private val characterClassDbToDomainFactory: CharacterClassDbToDomainFactory,
    private val attributeDbToDomainMapper: Mapper<AttributeEntity, Attribute>,
    private val movementSpeedDbToDomainMapper: Mapper<MovementSpeedEntity, MovementSpeed>,
): Mapper<CharacterEntity, Character> {
    override fun map(value: CharacterEntity): Character  {
        val characterClass = characterClassDbToDomainFactory.createCharacterClass(value.characterClass.level, value.characterClass.name)
        return Character(
            name = value.name,
            characterClass = characterClass,
            race = raceDbToDomainMapper.map(value.race),
            level = characterClass.level,
            baseStrength = attributeDbToDomainMapper.map(value.baseStrength),
            baseDexterity = attributeDbToDomainMapper.map(value.baseDexterity),
            baseConstitution = attributeDbToDomainMapper.map(value.baseConstitution),
            baseIntelligence = attributeDbToDomainMapper.map(value.baseIntelligence),
            baseWisdom = attributeDbToDomainMapper.map(value.baseWisdom),
            baseCharisma = attributeDbToDomainMapper.map(value.baseCharisma),
            temporaryStrModifier = attributeDbToDomainMapper.map(value.temporaryStrModifier),
            temporaryDexModifier = attributeDbToDomainMapper.map(value.temporaryDexModifier),
            temporaryConModifier = attributeDbToDomainMapper.map(value.temporaryConModifier),
            temporaryIntModifier = attributeDbToDomainMapper.map(value.temporaryIntModifier),
            temporaryWisModifier = attributeDbToDomainMapper.map(value.temporaryWisModifier),
            temporaryChaModifier = attributeDbToDomainMapper.map(value.temporaryChaModifier),
            movementSpeed = movementSpeedDbToDomainMapper.map(value.movementSpeed),
        )
    }
}