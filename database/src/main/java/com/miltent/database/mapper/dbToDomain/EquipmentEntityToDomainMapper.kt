package com.miltent.database.mapper.dbToDomain

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.equipment.EquipmentEntity
import com.miltent.domain.model.ArmorCategory
import com.miltent.domain.model.EqRarity
import com.miltent.domain.model.EqType
import com.miltent.domain.model.Equipment
import javax.inject.Inject


class EquipmentEntityToDomainMapper @Inject constructor(): Mapper<EquipmentEntity, Equipment> {
    override fun map(value: EquipmentEntity): Equipment =
        Equipment(
            name = value.name,
            type = EqType.entries.find { value.type == it.name } ?: throw IllegalArgumentException(),
            rarity = EqRarity.entries.find { value.rarity == it.name } ?: throw IllegalArgumentException(),
            description = value.description,
            armorCategory = ArmorCategory.entries.find { value.armorCategory == it.name } ?: throw IllegalArgumentException(),
            armorClassValue = value.armorClassValue,
            strengthRequirement = value.strengthRequirement,
            stealthDisadvantage = value.stealthDisadvantage
        )
}