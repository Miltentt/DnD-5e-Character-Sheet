package com.miltent.database.dao

import androidx.room.Dao
import androidx.room.Upsert
import com.miltent.database.entities.CharacterEntity

@Dao
interface CharacterDao {

    @Upsert
    suspend fun insertCharacter(character: CharacterEntity)

    suspend fun getAllCharacters(): List<CharacterEntity>

    suspend fun getCharacterById(id: Int): CharacterEntity
}