package com.miltent.core.useCase

import com.miltent.core.repository.EquipmentRepository
import javax.inject.Inject

class GetEquipmentForCharacterUseCase @Inject constructor(
    val repository: EquipmentRepository
) {
    operator fun invoke(characterId: String) = repository.getEquipmentForCharacter(characterId)
}