package com.miltent.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.miltent.domain.model.HealthPoints

@Entity(
    tableName = CharacterEntity.TABLE_NAME
)
class CharacterEntity(
    @ColumnInfo(name = "id")
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
    @ColumnInfo(name = "skills")
    val skillIds: List<String>,
    @ColumnInfo(name = "maxHealthPoints")
    val maxHealthPoints: Int,
    @ColumnInfo(name = "currantHealthPoints")
    val currantHealthPoints: Int,
    @ColumnInfo(name = "temporaryHealthPoints")
    val temporaryHealthPoints: Int

) {
    companion object {
        const val TABLE_NAME = "Characters"
    }
}