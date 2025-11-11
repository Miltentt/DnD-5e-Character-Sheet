package com.miltent.database.mapper.domainToDb

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.character.CharacterClassEntity
import com.miltent.database.entities.character.CharacterEntity
import com.miltent.database.entities.character.RaceEntity
import com.miltent.domain.model.Character
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.domain.model.StatisticType
import javax.inject.Inject

class CharacterDomainToEntityMapper @Inject constructor(
    private val characterClassDomainToEntityMapper: Mapper<CharacterClass, CharacterClassEntity>,
    private val raceDomainToEntityMapper: Mapper<Race, RaceEntity>,
) : Mapper<Character, CharacterEntity> {
    override fun map(value: Character): CharacterEntity = CharacterEntity(
        id = value.id,
        name = value.name,
        characterClass = characterClassDomainToEntityMapper.map(value.characterClass),
        race = raceDomainToEntityMapper.map(value.race),
        baseStrength = value.baseAttributes.values.getValue(StatisticType.STR).value,
        baseDexterity = value.baseAttributes.values.getValue(StatisticType.DEX).value,
        baseConstitution = value.baseAttributes.values.getValue(StatisticType.CON).value,
        baseIntelligence = value.baseAttributes.values.getValue(StatisticType.INT).value,
        baseWisdom = value.baseAttributes.values.getValue(StatisticType.WIS).value,
        baseCharisma = value.baseAttributes.values.getValue(StatisticType.CHA).value,
        temporaryStrModifier = value.temporaryAttributes.values.getValue(StatisticType.STR).value,
        temporaryDexModifier = value.temporaryAttributes.values.getValue(StatisticType.DEX).value,
        temporaryConModifier = value.temporaryAttributes.values.getValue(StatisticType.CON).value,
        temporaryIntModifier = value.temporaryAttributes.values.getValue(StatisticType.INT).value,
        temporaryWisModifier = value.temporaryAttributes.values.getValue(StatisticType.WIS).value,
        temporaryChaModifier = value.temporaryAttributes.values.getValue(StatisticType.CHA).value,
        movementSpeed = value.movementSpeed.value,
        maxHealthPoints = value.healthPoints.max,
        currantHealthPoints = value.healthPoints.current,
        temporaryHealthPoints = value.healthPoints.temporary
    )
}