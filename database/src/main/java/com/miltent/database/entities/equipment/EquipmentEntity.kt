package com.miltent.database.entities.equipment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.miltent.database.entities.equipment.EquipmentEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
class EquipmentEntity(
    @ColumnInfo(name = "equipmentId")
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "rarity")
    val rarity: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "armorCategory")
    val armorCategory: String,
    @ColumnInfo(name = "armorClassValue")
    val armorClassValue: Int,
    @ColumnInfo(name = "strengthRequirement")
    val strengthRequirement: Int,
    @ColumnInfo(name = "stealthDisadvantage")
    val stealthDisadvantage: Boolean,
){
    companion object {
        const val TABLE_NAME = "Equipment"
    }
}