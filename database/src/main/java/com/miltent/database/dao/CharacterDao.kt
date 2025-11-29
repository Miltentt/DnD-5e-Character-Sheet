package com.miltent.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.miltent.database.entities.character.CharacterEntity
import com.miltent.database.entities.character.CharacterWithSkillsAndSpecialAbilitiesEntity
import kotlinx.coroutines.flow.Flow
import com.miltent.database.entities.junctionTables.CharacterSkillCrossJunction
import com.miltent.database.entities.junctionTables.CharacterSpecialAbilityJunction

@Dao
interface CharacterDao {

    @Query("DELETE FROM ${CharacterEntity.TABLE_NAME} WHERE characterId = :id")
    suspend fun deleteCharacter(id: String)

    @Upsert
    suspend fun upsertCharacter(character: CharacterEntity): Long

    @Query("SELECT * FROM ${CharacterEntity.TABLE_NAME}")
    fun getAllCharacters(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM ${CharacterEntity.TABLE_NAME} WHERE characterId = :id")
    fun getCharacterById(id: String):  Flow<CharacterEntity>

    @Transaction
    @Query("SELECT * FROM ${CharacterEntity.TABLE_NAME} WHERE characterId = :id")
    fun getFullCharacterById(id: String): Flow<CharacterWithSkillsAndSpecialAbilitiesEntity>

    @Upsert
    suspend fun insertSkillJunction(junctions: List<CharacterSkillCrossJunction>)

    @Upsert
    suspend fun insertSpecialAbilityJunction(junctions: List<CharacterSpecialAbilityJunction>)

    @Transaction
    suspend fun upsertJunctions(skillJunctions: List<CharacterSkillCrossJunction>, specialAbilityJunctions: List<CharacterSpecialAbilityJunction>) {
        insertSkillJunction(skillJunctions)
        insertSpecialAbilityJunction(specialAbilityJunctions)

    }
}