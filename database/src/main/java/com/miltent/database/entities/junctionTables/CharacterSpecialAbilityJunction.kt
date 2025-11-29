package com.miltent.database.entities.junctionTables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.miltent.database.entities.character.CharacterEntity
import com.miltent.database.entities.junctionTables.CharacterSpecialAbilityJunction.Companion.TABLE_NAME

@Entity(
    tableName = TABLE_NAME,
    primaryKeys = ["characterId", "specialAbilityId"],
    foreignKeys = [
        ForeignKey(
            entity = CharacterEntity::class,
            parentColumns = ["characterId"],
            childColumns = ["characterId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
    )
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