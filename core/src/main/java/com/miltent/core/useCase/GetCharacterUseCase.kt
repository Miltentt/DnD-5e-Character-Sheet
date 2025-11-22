package com.miltent.core.useCase

import com.miltent.core.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    val characterRepository: CharacterRepository
) {
    operator fun invoke(characterId: String) = characterRepository.getCharacterById(characterId)
}