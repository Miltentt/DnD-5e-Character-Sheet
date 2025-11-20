package com.miltent.core.repository

import com.miltent.domain.model.Character
import com.miltent.domain.model.CharacterDetailed
import com.miltent.domain.model.DashboardCharacter
import kotlinx.coroutines.flow.Flow
import java.util.Locale

interface CharacterRepository {

    fun getCharacters(): Flow<List<DashboardCharacter>>

    fun getCharacterById(id: Int): Flow<Character>

    fun getCharacterDetailedById(id: Int, language: Locale): Flow<CharacterDetailed>

    suspend fun upsertCharacter(character: Character, skillIds: List<Int>, specialAbilityIds: List<String>)
}