package com.miltent.core.repository

import com.miltent.domain.model.Character
import com.miltent.domain.model.DashboardCharacter
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getCharacters(): Flow<List<DashboardCharacter>>

    suspend fun getCharacterById(id: Int): Flow<Character>

    suspend fun upsertCharacter(character: Character)
}