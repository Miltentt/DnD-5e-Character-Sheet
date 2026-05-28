package com.miltent.core.useCase

import com.miltent.core.repository.EquipmentRepository
import com.miltent.domain.model.Equipment
import jakarta.inject.Inject

class InsertEquipmentUseCase @Inject constructor(
    val repository: EquipmentRepository
) {
    suspend operator fun invoke(
        equipment: Equipment, characterId: String
    ) = repository.insertEquipmentWithJunction(equipment, characterId)
}