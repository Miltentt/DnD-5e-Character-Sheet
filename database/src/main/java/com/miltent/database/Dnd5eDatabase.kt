package com.miltent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miltent.database.dao.CharacterDao
import com.miltent.database.entities.AttributeEntity
import com.miltent.database.entities.CharacterClassEntity
import com.miltent.database.entities.CharacterEntity
import com.miltent.database.entities.MovementSpeedEntity
import com.miltent.database.entities.RaceEntity

@Database(
    entities = [
        CharacterEntity::class,
        RaceEntity::class,
        CharacterClassEntity::class,
        AttributeEntity::class,
        MovementSpeedEntity::class
    ],
    version = 1
)
abstract class Dnd5eDatabase: RoomDatabase() {

    abstract fun characterDao(): CharacterDao
}