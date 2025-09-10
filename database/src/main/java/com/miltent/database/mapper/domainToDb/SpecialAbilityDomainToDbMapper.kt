package com.miltent.database.mapper.domainToDb

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.SpecialAbilityEntity
import com.miltent.domain.model.ArmorClass
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.SpecialAbility
import javax.inject.Inject

class SpecialAbilityDomainToDbMapper @Inject constructor(
): Mapper<SpecialAbility, SpecialAbilityEntity> {
    override fun map(value: SpecialAbility): SpecialAbilityEntity = SpecialAbilityEntity(
        id = value.id,
        name = value.name,
        description = value.description,
        strengthModifier = value.strengthModifier.value,
        dexterityModifier = value.dexterityModifier.value,
        charismaModifier = value.charismaModifier.value,
        constitutionModifier = value.constitutionModifier.value,
        intelligenceModifier = value.intelligenceModifier.value,
        wisdomModifier = value.wisdomModifier.value,
        movementSpeedModifier = value.movementSpeedModifier.value,
        armorClassModifier = value.armorClassModifier.value
    )
}