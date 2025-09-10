package com.miltent.core.useCase

import com.miltent.core.repository.CharacterRepository
import com.miltent.domain.model.Character
import javax.inject.Inject

class InsertCharacterUseCase @Inject constructor(private val characterRepository: CharacterRepository) {

    suspend operator fun invoke(character: Character) = characterRepository.upsertCharacter(character)
}