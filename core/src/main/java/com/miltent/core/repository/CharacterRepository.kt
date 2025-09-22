package com.miltent.core.repository

import com.miltent.domain.model.Character
import com.miltent.domain.model.DashboardCharacter
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacters(): Flow<List<DashboardCharacter>>

    fun getCharacterById(id: Int): Flow<Character>

    suspend fun upsertCharacter(character: Character)
}