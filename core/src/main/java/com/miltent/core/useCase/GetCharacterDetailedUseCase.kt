package com.miltent.core.useCase

import android.content.Context
import com.miltent.core.repository.CharacterRepository
import com.miltent.domain.model.CharacterDetailed
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterDetailedUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val characterRepository: CharacterRepository
) {
    operator fun invoke(characterId: String): Flow<CharacterDetailed> {
        val locale = context.resources.configuration.locales[0]
        return characterRepository.getCharacterDetailedById(
            id = characterId,
            language = locale
        )
    }
}