package com.miltent.database.entities.junctionTables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.miltent.database.entities.character.CharacterEntity
import com.miltent.database.entities.equipment.EquipmentEntity
import com.miltent.database.entities.junctionTables.CharacterEquipmentJunction.Companion.TABLE_NAME

@Entity(
    tableName = TABLE_NAME,
    primaryKeys = ["characterId", "equipmentId"],
    foreignKeys = [
        ForeignKey(
            entity = CharacterEntity::class,
            parentColumns = ["characterId"],
            childColumns = ["characterId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class CharacterEquipmentJunction (
    @ColumnInfo(name = "characterId")
    val characterId: String,
    @ColumnInfo(name = "equipmentId")
    val equipmentId: String,
){
    companion object {
        const val TABLE_NAME = "CharacterEquipmentJunction"
    }
}