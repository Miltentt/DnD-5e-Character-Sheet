package com.miltent.database.factory.dbToDomain

import com.miltent.database.entities.specialAbility.SpecialAbilityEntity
import com.miltent.database.entities.specialAbility.SpecialAbilityTranslationEntity
import com.miltent.domain.model.ArmorClass
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Attributes
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.SpecialAbility
import com.miltent.domain.model.SpecialAbilityType
import com.miltent.domain.model.StatisticType
import javax.inject.Inject

class SpecialAbilityDbToDomainFactoryImpl @Inject constructor(
) : SpecialAbilityDbToDomainFactory {
    override fun create(
        value: SpecialAbilityEntity,
        specialAbilityTranslationEntity: SpecialAbilityTranslationEntity?
    ): SpecialAbility = SpecialAbility(
        id = value.id,
        name = specialAbilityTranslationEntity?.name.orEmpty(),
        type = SpecialAbilityType.getSpecialAbilityType(value.type),
        description = specialAbilityTranslationEntity?.description.orEmpty(),
        attributeModifiers = Attributes(
            mutableMapOf<StatisticType, Attribute>(
                StatisticType.STR to Attribute(value.strengthModifier),
                StatisticType.DEX to Attribute(value.dexterityModifier),
                StatisticType.CON to Attribute(value.constitutionModifier),
                StatisticType.INT to Attribute(value.intelligenceModifier),
                StatisticType.WIS to Attribute(value.wisdomModifier),
                StatisticType.CHA to Attribute(value.charismaModifier)
            )
        ),
        movementSpeedModifier = MovementSpeed(value.movementSpeedModifier),
        armorClassModifier = ArmorClass(value.armorClassModifier)
    )
}