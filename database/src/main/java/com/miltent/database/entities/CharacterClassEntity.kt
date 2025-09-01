package com.miltent.database.entities

import androidx.annotation.Keep
import androidx.room.Entity

@Entity
class CharacterClassEntity(
    val level: Int,
    val name: String,
    @Keep
    val movementSpeedModifier: MovementSpeedEntity
)