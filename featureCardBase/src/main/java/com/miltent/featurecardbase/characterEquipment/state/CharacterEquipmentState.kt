package com.miltent.featurecardbase.characterEquipment.state

import com.miltent.core.ui.ViewState
import com.miltent.featurecardbase.characterEquipment.model.EqArmorValues
import com.miltent.featurecardbase.characterEquipment.model.EqBasicInfo

data class CharacterEquipmentState(
    val basicInfo: EqBasicInfo = EqBasicInfo(),
    val armorValues: EqArmorValues = EqArmorValues()
) : ViewState