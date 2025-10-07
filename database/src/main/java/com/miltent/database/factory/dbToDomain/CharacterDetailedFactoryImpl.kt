package com.miltent.database.factory.dbToDomain

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.character.CharacterWithSkillsAndSpecialAbilitiesEntity
import com.miltent.database.entities.character.RaceEntity
import com.miltent.database.entities.skills.SkillTranslationEntity
import com.miltent.database.entities.specialAbility.SpecialAbilityTranslationEntity
import com.miltent.domain.model.ArmorClass
import com.miltent.domain.model.Attribute
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
                baseStrength = Attribute(character.baseStrength),
                baseDexterity = Attribute(character.baseDexterity),
                baseConstitution = Attribute(character.baseConstitution),
                baseIntelligence = Attribute(character.baseIntelligence),
                baseWisdom = Attribute(character.baseWisdom),
                baseCharisma = Attribute(character.baseCharisma),
                temporaryStrModifier = Attribute(character.temporaryStrModifier),
                temporaryDexModifier = Attribute(character.temporaryDexModifier),
                temporaryConModifier = Attribute(character.temporaryConModifier),
                temporaryIntModifier = Attribute(character.temporaryIntModifier),
                temporaryWisModifier = Attribute(character.temporaryWisModifier),
                temporaryChaModifier = Attribute(character.temporaryChaModifier),
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
                        strengthModifier = Attribute(specialAbility.strengthModifier),
                        dexterityModifier = Attribute(specialAbility.dexterityModifier),
                        charismaModifier = Attribute(specialAbility.charismaModifier),
                        constitutionModifier = Attribute(specialAbility.constitutionModifier),
                        intelligenceModifier = Attribute(specialAbility.intelligenceModifier),
                        wisdomModifier = Attribute(specialAbility.wisdomModifier),
                        movementSpeedModifier = MovementSpeed(specialAbility.movementSpeedModifier),
                        armorClassModifier = ArmorClass(specialAbility.armorClassModifier)
                    )
                }
            )
        }
}