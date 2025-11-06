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
        name = value.name,
        characterClass = characterClassDomainToEntityMapper.map(value.characterClass),
        race = raceDomainToEntityMapper.map(value.race),
        baseStrength = value.baseAttributes.values[StatisticType.STR]?.value ?: throw IllegalArgumentException("baseStrength cannot be null"),
        baseDexterity = value.baseAttributes.values[StatisticType.DEX]?.value ?: throw IllegalArgumentException("baseDexterity cannot be null"),
        baseConstitution = value.baseAttributes.values[StatisticType.CON]?.value ?: throw IllegalArgumentException("baseConstitution cannot be null"),
        baseIntelligence = value.baseAttributes.values[StatisticType.INT]?.value ?: throw IllegalArgumentException("baseIntelligence cannot be null"),
        baseWisdom = value.baseAttributes.values[StatisticType.WIS]?.value ?: throw IllegalArgumentException("baseWisdom cannot be null"),
        baseCharisma = value.baseAttributes.values[StatisticType.CHA]?.value ?: throw IllegalArgumentException("baseCharisma cannot be null"),
        temporaryStrModifier = value.temporaryAttributes.values[StatisticType.STR]?.value ?: throw IllegalArgumentException("temporaryStrModifier cannot be null"),
        temporaryDexModifier = value.temporaryAttributes.values[StatisticType.DEX]?.value ?: throw IllegalArgumentException("temporaryDexModifier cannot be null"),
        temporaryConModifier = value.temporaryAttributes.values[StatisticType.CON]?.value ?: throw IllegalArgumentException("temporaryConModifier cannot be null"),
        temporaryIntModifier = value.temporaryAttributes.values[StatisticType.INT]?.value ?: throw IllegalArgumentException("temporaryIntModifier cannot be null"),
        temporaryWisModifier = value.temporaryAttributes.values[StatisticType.WIS]?.value ?: throw IllegalArgumentException("temporaryWisModifier cannot be null"),
        temporaryChaModifier = value.temporaryAttributes.values[StatisticType.CHA]?.value ?: throw IllegalArgumentException("temporaryChaModifier cannot be null"),
        /*baseStrength = value.baseStrength.value,
        baseDexterity = value.baseDexterity.value,
        baseConstitution = value.baseConstitution.value,
        baseIntelligence = value.baseIntelligence.value,
        baseWisdom = value.baseWisdom.value,
        baseCharisma = value.baseCharisma.value,
        temporaryStrModifier = value.temporaryStrModifier.value,
        temporaryDexModifier = value.temporaryDexModifier.value,
        temporaryConModifier = value.temporaryConModifier.value,
        temporaryIntModifier = value.temporaryIntModifier.value,
        temporaryWisModifier = value.temporaryWisModifier.value,
        temporaryChaModifier = value.temporaryChaModifier.value,*/
        movementSpeed = value.movementSpeed.value,
        maxHealthPoints = value.healthPoints.max,
        currantHealthPoints = value.healthPoints.current,
        temporaryHealthPoints = value.healthPoints.temporary
    )
}