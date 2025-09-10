package com.miltent.database.mapper.dbToDomain

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.SpecialAbilityEntity
import com.miltent.domain.model.ArmorClass
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.SpecialAbility
import javax.inject.Inject

class SpecialAbilityDbToDomainMapper @Inject constructor(
): Mapper<SpecialAbilityEntity, SpecialAbility> {
    override fun map(value: SpecialAbilityEntity): SpecialAbility = SpecialAbility(
        id = value.id,
        name = value.name,
        description = value.description,
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