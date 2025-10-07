package com.miltent.database.entities.character

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.miltent.database.entities.character.CharacterEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CharacterEntity(
    @ColumnInfo(name = "characterId")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @Embedded
    val race: RaceEntity,
    @Embedded
    val characterClass: CharacterClassEntity,
    @ColumnInfo(name = "baseStrength")
    val baseStrength: Int,
    @ColumnInfo(name = "baseDexterity")
    val baseDexterity: Int,
    @ColumnInfo(name = "baseConstitution")
    val baseConstitution: Int,
    @ColumnInfo(name = "baseIntelligence")
    val baseIntelligence: Int,
    @ColumnInfo(name = "baseWisdom")
    val baseWisdom: Int,
    @ColumnInfo(name = "baseCharisma")
    val baseCharisma: Int,
    @ColumnInfo(name = "temporaryStrModifier")
    val temporaryStrModifier: Int,
    @ColumnInfo(name = "temporaryDexModifier")
    val temporaryDexModifier: Int,
    @ColumnInfo(name = "temporaryConModifier")
    val temporaryConModifier: Int,
    @ColumnInfo(name = "temporaryIntModifier")
    val temporaryIntModifier: Int,
    @ColumnInfo(name = "temporaryWisModifier")
    val temporaryWisModifier: Int,
    @ColumnInfo(name = "temporaryChaModifier")
    val temporaryChaModifier: Int,
    @ColumnInfo(name = "movementSpeed")
    val movementSpeed: Double,
    @ColumnInfo(name = "maxHealthPoints")
    val maxHealthPoints: Int,
    @ColumnInfo(name = "currentHealthPoints")
    val currentHealthPoints: Int
) {
    companion object {
        const val TABLE_NAME = "Characters"
    }
}