package com.miltent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miltent.database.dao.CharacterDao
import com.miltent.database.entities.CharacterEntity

@Database(
    entities = [CharacterEntity::class],
    version = 1
)
abstract class Dnd5eDatabase: RoomDatabase() {

    abstract fun characterDao(): CharacterDao
}