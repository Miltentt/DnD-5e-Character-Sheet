package com.miltent.core.useCase

import com.miltent.core.repository.CharacterRepository
import javax.inject.Inject

class DeleteCharacterUseCase @Inject constructor(private val characterRepository: CharacterRepository) {

    suspend operator fun invoke(id: String) = characterRepository.deleteCharacterWithJunctions(id)
}