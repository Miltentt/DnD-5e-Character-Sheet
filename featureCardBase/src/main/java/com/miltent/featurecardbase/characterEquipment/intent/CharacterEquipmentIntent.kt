package com.miltent.featurecardbase.characterEquipment.intent

import com.miltent.core.intent.Intent
import com.miltent.domain.model.ArmorCategory
import com.miltent.domain.model.EqRarity
import com.miltent.domain.model.EqType
import com.miltent.domain.model.Property

interface CharacterEquipmentIntent : Intent {
    data object OnBaseInfoSectionToggle : CharacterEquipmentIntent
    data object OnArmorValuesSectionToggle : CharacterEquipmentIntent
    data class OnNameChange(val name: String) : CharacterEquipmentIntent
    data class OnTypeChange(val type: EqType) : CharacterEquipmentIntent
    data class OnRarityChange(val rarity: EqRarity) : CharacterEquipmentIntent
    data class OnDescriptionChange(val description: String) : CharacterEquipmentIntent
    data class OnArmorCategoryChange(val armorCategory: ArmorCategory) : CharacterEquipmentIntent
    data class OnArmorClassChangeByValue(val armorClassChangeValue: Int) : CharacterEquipmentIntent
    data class OnStrengthReqChangeByValue(val strengthReqChangeValue: Int) : CharacterEquipmentIntent
    data class OnPropertiesChange(val property: Property) : CharacterEquipmentIntent
    data object OnStealthDisadvantageToggle : CharacterEquipmentIntent
    data object OnAddEquipment : CharacterEquipmentIntent
}