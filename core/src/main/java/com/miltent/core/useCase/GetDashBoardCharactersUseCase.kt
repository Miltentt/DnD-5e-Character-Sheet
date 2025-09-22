package com.miltent.core.useCase

import com.miltent.core.repository.CharacterRepository
import com.miltent.domain.model.DashboardCharacter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDashBoardCharactersUseCase @Inject constructor(private val characterRepository: CharacterRepository) {

    operator fun invoke(): Flow<List<DashboardCharacter>> = characterRepository.getCharacters()
}


