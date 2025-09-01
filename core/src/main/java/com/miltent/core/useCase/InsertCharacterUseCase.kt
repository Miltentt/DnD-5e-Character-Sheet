package com.miltent.core.useCase

import com.miltent.domain.model.Character
import javax.inject.Inject

class InsertCharacterUseCase @Inject constructor() {

    suspend operator fun invoke(character: Character) {

    }
}