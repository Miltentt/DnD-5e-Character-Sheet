package com.miltent.featurecardbase.characterEquipment.mapper

import com.miltent.core.utility.Mapper
import com.miltent.domain.model.Equipment
import com.miltent.featurecardbase.characterEquipment.model.EqArmorValues
import com.miltent.featurecardbase.characterEquipment.model.EqBasicInfo
import com.miltent.featurecardbase.characterEquipment.state.CharacterEquipmentState
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class EquipmentToCharacterEquipmentStateMapper @Inject constructor() :
    Mapper<Equipment, CharacterEquipmentState> {
    override fun map(value: Equipment): CharacterEquipmentState {
        return CharacterEquipmentState(
            basicInfo = EqBasicInfo(
                name = value.name,
                type = value.type,
                rarity = value.rarity,
                description = value.description
            ),
            armorValues = EqArmorValues(
                armorCategory = value.armorCategory,
                armorClassValue = value.armorClassValue,
                strengthRequirement = value.strengthRequirement,
                stealthDisadvantage = value.stealthDisadvantage,
                properties = value.properties
            )
        )
    }
}