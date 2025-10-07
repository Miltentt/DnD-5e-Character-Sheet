package com.miltent.database.entities.junctionTables

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["characterId", "specialAbilityId"])
data class CharacterSpecialAbilityJunction(
    @ColumnInfo(name = "characterId")
    val characterId: Int,
    @ColumnInfo(name = "specialAbilityId")
    val specialAbilityId: String
)