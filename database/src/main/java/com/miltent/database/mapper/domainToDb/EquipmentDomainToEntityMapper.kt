package com.miltent.database.mapper.domainToDb

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.equipment.EquipmentEntity
import com.miltent.domain.model.Equipment
import jakarta.inject.Inject

class EquipmentDomainToEntityMapper @Inject constructor() : Mapper<Equipment, EquipmentEntity> {
    override fun map(
        value: Equipment
    ): EquipmentEntity = EquipmentEntity(
        id = "value.id",
        name = value.name,
        type = value.type.name,
        rarity = value.rarity.name,
        description = value.description,
        armorCategory = value.armorCategory?.name ?: "",
        armorClassValue = value.armorClassValue,
        strengthRequirement = value.strengthRequirement,
        stealthDisadvantage = value.stealthDisadvantage
    )
}