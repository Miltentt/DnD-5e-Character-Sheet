package com.miltent.database.factory.dbToDomain

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.character.CharacterWithSkillsAndSpecialAbilitiesEntity
import com.miltent.database.entities.character.RaceEntity
import com.miltent.database.entities.skills.SkillTranslationEntity
import com.miltent.database.entities.specialAbility.SpecialAbilityTranslationEntity
import com.miltent.domain.model.ArmorClass
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Attributes
import com.miltent.domain.model.CharacterDetailed
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.Race
import com.miltent.domain.model.Skill
import com.miltent.domain.model.SpecialAbility
import com.miltent.domain.model.SpecialAbilityType
import com.miltent.domain.model.StatisticType
import javax.inject.Inject

class CharacterDetailedFactoryImpl @Inject constructor(
    private val raceDbToDomainMapper: Mapper<RaceEntity, Race>,
    private val characterClassDbToDomainFactory: CharacterClassDbToDomainFactory,
): CharacterDetailedFactory {

    override fun create(
        characterWithAdditionalInfo: CharacterWithSkillsAndSpecialAbilitiesEntity,
        skillTranslations: List<SkillTranslationEntity>,
        specialAbilityTranslations: List<SpecialAbilityTranslationEntity>
    ): CharacterDetailed =
        with(characterWithAdditionalInfo) {
            val characterClass = characterClassDbToDomainFactory.createCharacterClass(character.characterClass.level, character.characterClass.characterClassIdentifier)
            CharacterDetailed(
                name = character.name,
                characterClass = characterClass,
                race = raceDbToDomainMapper.map(character.race),
                level = characterClass.level,
                baseAttributes = Attributes(
                    mapOf<StatisticType, Attribute>(
                        StatisticType.STR to Attribute(character.baseStrength),
                        StatisticType.DEX to Attribute(character.baseDexterity),
                        StatisticType.CON to Attribute(character.baseConstitution),
                        StatisticType.INT to Attribute(character.baseIntelligence),
                        StatisticType.WIS to Attribute(character.baseWisdom),
                        StatisticType.CHA to Attribute(character.baseCharisma)
                    )
                ),
                temporaryModifiers = Attributes(
                    mapOf<StatisticType, Attribute>(
                        StatisticType.STR to Attribute(character.temporaryStrModifier),
                        StatisticType.DEX to Attribute(character.temporaryDexModifier),
                        StatisticType.CON to Attribute(character.temporaryConModifier),
                        StatisticType.INT to Attribute(character.temporaryIntModifier),
                        StatisticType.WIS to Attribute(character.temporaryWisModifier),
                        StatisticType.CHA to Attribute(character.temporaryChaModifier)
                    )
                ),
                movementSpeed = MovementSpeed(character.movementSpeed),
                skills = skills.map { skill ->
                    Skill(
                        id = skill.id,
                        name = skillTranslations.find { it.skillId == skill.id }?.name.orEmpty(),
                        statisticType = StatisticType.getStatisticType(skill.statisticType)
                    )
                },
                specialAbilities = specialAbilities.map { specialAbility ->
                    SpecialAbility(
                        id = specialAbility.id,
                        name = specialAbilityTranslations.find { it.specialAbilityId == specialAbility.id }?.name.orEmpty(),
                        type = SpecialAbilityType.getSpecialAbilityType(specialAbility.type),
                        description = specialAbilityTranslations.find { it.specialAbilityId == specialAbility.id }?.description.orEmpty(),
                        attributeModifiers = Attributes(
                            mapOf<StatisticType, Attribute>(
                                StatisticType.STR to Attribute(specialAbility.strengthModifier),
                                StatisticType.DEX to Attribute(specialAbility.dexterityModifier),
                                StatisticType.CON to Attribute(specialAbility.constitutionModifier),
                                StatisticType.INT to Attribute(specialAbility.intelligenceModifier),
                                StatisticType.WIS to Attribute(specialAbility.wisdomModifier),
                                StatisticType.CHA to Attribute(specialAbility.charismaModifier)
                            )

                        ),
                        movementSpeedModifier = MovementSpeed(specialAbility.movementSpeedModifier),
                        armorClassModifier = ArmorClass(specialAbility.armorClassModifier)
                    )
                }
            )
        }
}