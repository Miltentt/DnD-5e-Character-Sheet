package com.miltent.featurecardbase.characterEquipment.model

import com.miltent.domain.model.ArmorCategory
import com.miltent.domain.model.Property

data class EqArmorValues(
    val eqSectionInfo: EqSectionInfo = EqSectionInfo(name = "Armor Values"),
    val armorCategory: ArmorCategory? = null,
    val armorClassValue: Int = 10,
    val strengthRequirement: Int = 15,
    val stealthDisadvantage: Boolean = false,
    val properties: Set<Property> = emptySet()
)