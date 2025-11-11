package com.miltent.core.repository

import com.miltent.domain.model.Character
import com.miltent.domain.model.CharacterDetailed
import com.miltent.domain.model.DashboardCharacter
import kotlinx.coroutines.flow.Flow
import java.util.Locale

interface CharacterRepository {

    suspend fun deleteCharacterWithJunctions(id: String)

    fun getCharacters(): Flow<List<DashboardCharacter>>

    fun getCharacterById(id: String): Flow<Character>

    fun getCharacterDetailedById(id: String, language: Locale): Flow<CharacterDetailed>

    suspend fun upsertCharacter(character: Character, skillIds: List<String>, specialAbilityIds: List<String>)
}