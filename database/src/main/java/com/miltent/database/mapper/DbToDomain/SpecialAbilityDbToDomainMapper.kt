package com.miltent.database.mapper.DbToDomain

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.AttributeEntity
import com.miltent.database.entities.MovementSpeedEntity
import com.miltent.database.entities.SpecialAbilityEntity
import com.miltent.domain.model.Attribute
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.SpecialAbility
import javax.inject.Inject

class SpecialAbilityDbToDomainMapper @Inject constructor(
    private val attributeDbToDomainMapper: Mapper<AttributeEntity, Attribute>,
    private val movementSpeedDbToDomainMapper: Mapper<MovementSpeedEntity, MovementSpeed>
): Mapper<SpecialAbilityEntity, SpecialAbility> {
    override fun map(value: SpecialAbilityEntity): SpecialAbility = SpecialAbility(
        description = value.description,
        strengthModifier = attributeDbToDomainMapper.map(value.strengthModifier),
        dexterityModifier = attributeDbToDomainMapper.map(value.dexterityModifier),
        charismaModifier = attributeDbToDomainMapper.map(value.charismaModifier),
        constitutionModifier = attributeDbToDomainMapper.map(value.constitutionModifier),
        intelligenceModifier = attributeDbToDomainMapper.map(value.intelligenceModifier),
        wisdomModifier = attributeDbToDomainMapper.map(value.wisdomModifier),
        movementSpeedModifier = movementSpeedDbToDomainMapper.map(value.movementSpeedModifier),
        armorClassModifier = value.armorClassModifier
    )
}