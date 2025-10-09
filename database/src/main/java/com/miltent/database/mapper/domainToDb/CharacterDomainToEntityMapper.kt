package com.miltent.database.mapper.domainToDb

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.CharacterClassEntity
import com.miltent.database.entities.CharacterEntity
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
) : Mapper<Character, CharacterEntity> {
    override fun map(value: Character): CharacterEntity = CharacterEntity(
        name = value.name,
        characterClass = characterClassDomainToEntityMapper.map(value.characterClass),
        race = raceDomainToEntityMapper.map(value.race),
        baseStrength = value.baseStrength.value,
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
        temporaryChaModifier = value.temporaryChaModifier.value,
        movementSpeed = value.movementSpeed.value,
        skillIds = value.skills.map { it.id },
        maxHealthPoints = value.healthPoints.max,
        currantHealthPoints = value.healthPoints.current,
        temporaryHealthPoints = value.healthPoints.temporary
    )

}