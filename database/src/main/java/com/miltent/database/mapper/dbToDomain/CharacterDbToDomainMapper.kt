package com.miltent.database.mapper.dbToDomain

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.character.CharacterEntity
import com.miltent.database.entities.character.RaceEntity
import com.miltent.database.factory.dbToDomain.CharacterClassDbToDomainFactory
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Attributes
import javax.inject.Inject
import com.miltent.domain.model.Character
import com.miltent.domain.model.HealthPoints
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.Race
import com.miltent.domain.model.StatisticType

class CharacterDbToDomainMapper @Inject constructor(
    private val raceDbToDomainMapper: Mapper<RaceEntity, Race>,
    private val characterClassDbToDomainFactory: CharacterClassDbToDomainFactory,
) : Mapper<CharacterEntity, Character> {
    override fun map(value: CharacterEntity): Character {
        val characterClass = characterClassDbToDomainFactory.createCharacterClass(
            value.characterClass.level,
            value.characterClass.characterClassIdentifier
        )
        return Character(
            name = value.name,
            characterClass = characterClass,
            race = raceDbToDomainMapper.map(value.race),
            level = characterClass.level,
            baseAttributes = Attributes(
                mutableMapOf<StatisticType, Attribute>(
                    StatisticType.STR to Attribute(value.baseStrength),
                    StatisticType.DEX to Attribute(value.baseDexterity),
                    StatisticType.CON to Attribute(value.baseConstitution),
                    StatisticType.INT to Attribute(value.baseIntelligence),
                    StatisticType.WIS to Attribute(value.baseWisdom),
                    StatisticType.CHA to Attribute(value.baseCharisma)
                )
            ),
            temporaryAttributes = Attributes(
                mutableMapOf<StatisticType, Attribute>(
                    StatisticType.STR to Attribute(value.temporaryStrModifier),
                    StatisticType.DEX to Attribute(value.temporaryDexModifier),
                    StatisticType.CON to Attribute(value.temporaryConModifier),
                    StatisticType.INT to Attribute(value.temporaryIntModifier),
                    StatisticType.WIS to Attribute(value.temporaryWisModifier),
                    StatisticType.CHA to Attribute(value.temporaryChaModifier)
                )
            ),
            movementSpeed = MovementSpeed(value.movementSpeed),
            healthPoints = HealthPoints.makeFromData(
                value.maxHealthPoints,
                value.currantHealthPoints,
                value.temporaryHealthPoints
            )
        )
    }
}