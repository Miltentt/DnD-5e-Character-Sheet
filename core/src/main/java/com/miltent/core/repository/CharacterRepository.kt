package com.miltent.core.repository

import com.miltent.domain.model.Character
import com.miltent.domain.model.DashboardCharacter

interface CharacterRepository {

    fun getCharacters(): List<DashboardCharacter>

    fun getCharacterById(id: Int): Character

    fun upsertCharacter(character: Character)
}