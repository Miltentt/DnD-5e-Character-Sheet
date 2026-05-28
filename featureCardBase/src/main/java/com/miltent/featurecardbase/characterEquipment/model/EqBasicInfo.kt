package com.miltent.featurecardbase.characterEquipment.model

import com.miltent.domain.model.EqRarity
import com.miltent.domain.model.EqType

data class EqBasicInfo(
    val eqSectionInfo: EqSectionInfo = EqSectionInfo(name = "Basic Info"),
    val name: String = "",
    val type: EqType = EqType.Armor,
    val rarity: EqRarity = EqRarity.Common,
    val description: String = ""
)