package com.miltent.database.mapper.dbToDomain

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.CharacterEntity
import com.miltent.database.entities.RaceEntity
import com.miltent.database.factory.CharacterClassDbToDomainFactory
import com.miltent.domain.model.Attribute
import javax.inject.Inject
import com.miltent.domain.model.Character
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.Race
import com.miltent.domain.model.Skill

class CharacterDbToDomainMapper @Inject constructor(
    private val raceDbToDomainMapper: Mapper<RaceEntity, Race>,
    private val characterClassDbToDomainFactory: CharacterClassDbToDomainFactory,
): Mapper<CharacterEntity, Character> {
    override fun map(value: CharacterEntity): Character  {
        val characterClass = characterClassDbToDomainFactory.createCharacterClass(value.characterClass.level, value.characterClass.characterClassIdentifier)
        return Character(
            name = value.name,
            characterClass = characterClass,
            race = raceDbToDomainMapper.map(value.race),
            level = characterClass.level,
            baseStrength = Attribute(value.baseStrength),
            baseDexterity = Attribute(value.baseDexterity),
            baseConstitution = Attribute(value.baseConstitution),
            baseIntelligence = Attribute(value.baseIntelligence),
            baseWisdom = Attribute(value.baseWisdom),
            baseCharisma = Attribute(value.baseCharisma),
            temporaryStrModifier = Attribute(value.temporaryStrModifier),
            temporaryDexModifier = Attribute(value.temporaryDexModifier),
            temporaryConModifier = Attribute(value.temporaryConModifier),
            temporaryIntModifier = Attribute(value.temporaryIntModifier),
            temporaryWisModifier = Attribute(value.temporaryWisModifier),
            temporaryChaModifier = Attribute(value.temporaryChaModifier),
            movementSpeed = MovementSpeed(value.movementSpeed),
            skills = Skill.defaultSkillList.filter { it.id in value.skillIds }
        )
    }
}