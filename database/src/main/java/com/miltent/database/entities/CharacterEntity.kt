package com.miltent.database.entities

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    @Keep
    val race: RaceEntity,
    @Keep
    val characterClass: CharacterClassEntity,
    @Keep
    val baseStrength: AttributeEntity,
    @Keep
    val baseDexterity: AttributeEntity,
    @Keep
    val baseConstitution: AttributeEntity,
    @Keep
    val baseIntelligence: AttributeEntity,
    @Keep
    val baseWisdom: AttributeEntity,
    @Keep
    val baseCharisma: AttributeEntity,
    @Keep
    val temporaryStrModifier: AttributeEntity,
    @Keep
    val temporaryDexModifier: AttributeEntity,
    @Keep
    val temporaryConModifier: AttributeEntity,
    @Keep
    val temporaryIntModifier: AttributeEntity,
    @Keep
    val temporaryWisModifier: AttributeEntity,
    @Keep
    val temporaryChaModifier: AttributeEntity,
    @Keep
    val movementSpeed: MovementSpeedEntity,
) {
}