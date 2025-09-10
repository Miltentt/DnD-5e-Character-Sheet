package com.miltent.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.miltent.database.entities.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Upsert
    suspend fun insertCharacter(character: CharacterEntity)

    @Query("SELECT * FROM ${CharacterEntity.TABLE_NAME}")
    fun getAllCharacters(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM ${CharacterEntity.TABLE_NAME} WHERE id = :id")
    fun getCharacterById(id: Int):  Flow<CharacterEntity>
}