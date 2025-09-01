package com.miltent.database.mapper.domainToDb

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.AttributeEntity
import com.miltent.database.entities.MovementSpeedEntity
import com.miltent.database.entities.SpecialAbilityEntity
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.SpecialAbility
import javax.inject.Inject

class SpecialAbilityDomainToDbMapper @Inject constructor(
    private val attributeDomainToDbMapper: Mapper<Attribute, AttributeEntity>,
    private val movementSpeedDomainToDbMapper: Mapper<MovementSpeed, MovementSpeedEntity>,
): Mapper<SpecialAbility, SpecialAbilityEntity> {
    override fun map(value: SpecialAbility): SpecialAbilityEntity = SpecialAbilityEntity(
        description = value.description,
        strengthModifier = attributeDomainToDbMapper.map(value.strengthModifier),
        dexterityModifier = attributeDomainToDbMapper.map(value.dexterityModifier),
        charismaModifier = attributeDomainToDbMapper.map(value.charismaModifier),
        constitutionModifier = attributeDomainToDbMapper.map(value.constitutionModifier),
        intelligenceModifier = attributeDomainToDbMapper.map(value.intelligenceModifier),
        wisdomModifier = attributeDomainToDbMapper.map(value.wisdomModifier),
        movementSpeedModifier = movementSpeedDomainToDbMapper.map(value.movementSpeedModifier),
        armorClassModifier = value.armorClassModifier
    )
}