package com.miltent.database.entities.junctionTables

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.miltent.database.entities.junctionTables.CharacterSkillCrossJunction.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME, primaryKeys = ["characterId", "skillId"])
data class CharacterSkillCrossJunction(
    @ColumnInfo(name = "characterId")
    val characterId: String,
    @ColumnInfo(name = "skillId")
    val skillId: Int,
){
    companion object {
        const val TABLE_NAME = "CharacterSkillCrossJunction"
    }
}