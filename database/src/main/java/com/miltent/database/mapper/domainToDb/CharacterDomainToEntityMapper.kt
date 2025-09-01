package com.miltent.database.mapper.domainToDb

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.AttributeEntity
import com.miltent.database.entities.CharacterClassEntity
import com.miltent.database.entities.CharacterEntity
import com.miltent.database.entities.MovementSpeedEntity
import com.miltent.database.entities.RaceEntity
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Character
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.Race
import javax.inject.Inject

class CharacterDomainToEntityMapper @Inject constructor(
    private val characterClassDomainToEntityMapper: Mapper<CharacterClass, CharacterClassEntity>,
    private val raceDomainToEntityMapper: Mapper<Race, RaceEntity>,
    private val attributesDomainToEntityMapper: Mapper<Attribute, AttributeEntity>,
    private val movementSpeedDomainToEntityMapper: Mapper<MovementSpeed, MovementSpeedEntity>,
) : Mapper<Character, CharacterEntity> {
    override fun map(value: Character): CharacterEntity = CharacterEntity(
        name = value.name,
        characterClass = characterClassDomainToEntityMapper.map(value.characterClass),
        race = raceDomainToEntityMapper.map(value.race),
        level = value.level,
        baseStrength = attributesDomainToEntityMapper.map(value.baseStrength),
        baseDexterity = attributesDomainToEntityMapper.map(value.baseDexterity),
        baseConstitution = attributesDomainToEntityMapper.map(value.baseConstitution),
        baseIntelligence = attributesDomainToEntityMapper.map(value.baseIntelligence),
        baseWisdom = attributesDomainToEntityMapper.map(value.baseWisdom),
        baseCharisma = attributesDomainToEntityMapper.map(value.baseCharisma),
        temporaryStrModifier = attributesDomainToEntityMapper.map(value.temporaryStrModifier),
        temporaryDexModifier = attributesDomainToEntityMapper.map(value.temporaryDexModifier),
        temporaryConModifier = attributesDomainToEntityMapper.map(value.temporaryConModifier),
        temporaryIntModifier = attributesDomainToEntityMapper.map(value.temporaryIntModifier),
        temporaryWisModifier = attributesDomainToEntityMapper.map(value.temporaryWisModifier),
        temporaryChaModifier = attributesDomainToEntityMapper.map(value.temporaryChaModifier),
        movementSpeed = movementSpeedDomainToEntityMapper.map(value.movementSpeed),
    )

}