package com.miltent.database.entities

import androidx.annotation.Keep
import androidx.room.Entity
import com.miltent.domain.model.ArmorClass
import com.miltent.domain.model.MovementSpeed

@Entity
data class SpecialAbilityEntity(
    val description: String,
    @Keep
    val strengthModifier: AttributeEntity,
    @Keep
    val dexterityModifier: AttributeEntity,
    @Keep
    val charismaModifier: AttributeEntity,
    @Keep
    val constitutionModifier: AttributeEntity,
    @Keep
    val intelligenceModifier: AttributeEntity,
    @Keep
    val wisdomModifier: AttributeEntity,
    val movementSpeedModifier: MovementSpeedEntity,
    val armorClassModifier: ArmorClass
)
