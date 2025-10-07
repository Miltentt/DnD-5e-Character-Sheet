package com.miltent.database.entities.specialAbility

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.miltent.database.entities.specialAbility.SpecialAbilityEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class SpecialAbilityEntity(
    @ColumnInfo(name = "specialAbilityId")
    @PrimaryKey
    val id: String,
    val type: String,
    val strengthModifier: Int,
    val dexterityModifier: Int,
    val charismaModifier: Int,
    val constitutionModifier: Int,
    val intelligenceModifier: Int,
    val wisdomModifier: Int,
    val movementSpeedModifier: Double,
    val armorClassModifier: Int,
) {
    companion object {
        const val TABLE_NAME = "SpecialAbility"
    }
}