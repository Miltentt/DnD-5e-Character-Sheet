package com.miltent.database

import com.miltent.core.repository.CharacterRepository
import com.miltent.domain.model.Character
import com.miltent.domain.model.DashboardCharacter
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(): CharacterRepository {
    override fun getCharacters(): List<DashboardCharacter> {
        TODO("Not yet implemented")
    }

    override fun getCharacterById(id: Int): Character {
        TODO("Not yet implemented")
    }

    override fun upsertCharacter(character: Character) {
        TODO("Not yet implemented")
    }
}