package com.miltent.database.entities.junctionTables

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["characterId", "skillId"])
data class CharacterSkillCrossJunction(
    @ColumnInfo(name = "characterId")
    val characterId: Int,
    @ColumnInfo(name = "skillId")
    val skillId: String,
)