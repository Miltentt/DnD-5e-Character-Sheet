package com.miltent.featurecardbase.characterEquipment.mapper

import com.miltent.core.utility.Mapper
import com.miltent.domain.model.Equipment
import com.miltent.featurecardbase.characterEquipment.state.CharacterEquipmentState
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CharacterEquipmentStateToEquipmentMapper @Inject constructor() :
    Mapper<CharacterEquipmentState, Equipment> {
    override fun map(value: CharacterEquipmentState): Equipment {
        return Equipment(
            name = value.basicInfo.name,
            type = value.basicInfo.type,
            rarity = value.basicInfo.rarity,
            description = value.basicInfo.description,
            armorCategory = value.armorValues.armorCategory,
            armorClassValue = value.armorValues.armorClassValue,
            strengthRequirement = value.armorValues.strengthRequirement,
            stealthDisadvantage = value.armorValues.stealthDisadvantage,
            properties = value.armorValues.properties
        )
    }
}