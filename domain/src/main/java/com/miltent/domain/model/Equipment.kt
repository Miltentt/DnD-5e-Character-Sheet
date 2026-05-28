package com.miltent.domain.model

import java.util.UUID

data class Equipment(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "",
    val type: EqType = EqType.Weapon,
    val rarity: EqRarity = EqRarity.Common,
    val description: String = "",
    val armorCategory: ArmorCategory? = null,
    val armorClassValue: Int = 0,
    val strengthRequirement: Int = 10,
    val stealthDisadvantage: Boolean = false,
    val properties: Set<Property> = emptySet()
)

enum class EqType {
    Armor,
    Weapon,
    Clothes
}

enum class EqRarity {
    Common,
    Rear,
    Legendary
}

enum class ArmorCategory {
    Light,
    Medium,
    Heavy,
    Shield,
    Other
}

enum class Property {
    Ammunition,
    Finesse,
    Heavy,
    Light,
    Loading,
    Reach,
    Special,
    Thrown
}