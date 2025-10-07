package com.miltent.database.factory.dbToDomain

import com.miltent.database.entities.specialAbility.SpecialAbilityEntity
import com.miltent.database.entities.specialAbility.SpecialAbilityTranslationEntity
import com.miltent.domain.model.ArmorClass
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.SpecialAbility
import com.miltent.domain.model.SpecialAbilityType
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
        strengthModifier = Attribute(value.strengthModifier),
        dexterityModifier = Attribute(value.dexterityModifier),
        charismaModifier = Attribute(value.charismaModifier),
        constitutionModifier = Attribute(value.constitutionModifier),
        intelligenceModifier = Attribute(value.intelligenceModifier),
        wisdomModifier = Attribute(value.wisdomModifier),
        movementSpeedModifier = MovementSpeed(value.movementSpeedModifier),
        armorClassModifier = ArmorClass(value.armorClassModifier)
    )
}