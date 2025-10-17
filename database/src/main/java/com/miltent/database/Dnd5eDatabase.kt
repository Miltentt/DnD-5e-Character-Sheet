package com.miltent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miltent.database.dao.CharacterDao
import com.miltent.database.dao.SkillsDao
import com.miltent.database.dao.SpecialAbilityDao
import com.miltent.database.entities.character.CharacterEntity
import com.miltent.database.entities.junctionTables.CharacterSkillCrossJunction
import com.miltent.database.entities.junctionTables.CharacterSpecialAbilityJunction
import com.miltent.database.entities.skills.SkillEntity
import com.miltent.database.entities.skills.SkillTranslationEntity
import com.miltent.database.entities.specialAbility.SpecialAbilityEntity
import com.miltent.database.entities.specialAbility.SpecialAbilityTranslationEntity

@Database(
    entities = [
        CharacterEntity::class,
        SkillEntity::class,
        SpecialAbilityEntity::class,
        CharacterSkillCrossJunction::class,
        CharacterSpecialAbilityJunction::class,
        SkillTranslationEntity::class,
        SpecialAbilityTranslationEntity::class
    ],
    version = 1
)

abstract class Dnd5eDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    abstract fun skillsDao(): SkillsDao

    abstract fun specialAbilityDao(): SpecialAbilityDao
}