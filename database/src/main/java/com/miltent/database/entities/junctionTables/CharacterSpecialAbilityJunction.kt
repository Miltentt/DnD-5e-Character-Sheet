package com.miltent.database.entities.junctionTables

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.miltent.database.entities.junctionTables.CharacterSpecialAbilityJunction.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME, primaryKeys = ["characterId", "specialAbilityId"])
data class CharacterSpecialAbilityJunction(
    @ColumnInfo(name = "characterId")
    val characterId: String,
    @ColumnInfo(name = "specialAbilityId")
    val specialAbilityId: String
){
    companion object {
        const val TABLE_NAME = "CharacterSpecialAbilityCrossJunction"
    }
}