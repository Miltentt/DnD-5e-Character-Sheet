package com.miltent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.miltent.database.converters.SkillTypeConverters
import com.miltent.database.dao.CharacterDao
import com.miltent.database.entities.CharacterEntity

@Database(
    entities = [CharacterEntity::class],
    version = 2
)
@TypeConverters(SkillTypeConverters::class)
abstract class Dnd5eDatabase: RoomDatabase() {

    abstract fun characterDao(): CharacterDao
}