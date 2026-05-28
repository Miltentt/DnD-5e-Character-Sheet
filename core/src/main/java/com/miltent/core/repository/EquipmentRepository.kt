package com.miltent.core.repository

import com.miltent.domain.model.Equipment
import kotlinx.coroutines.flow.Flow

interface EquipmentRepository {

    suspend fun insertEquipmentWithJunction(equipment: Equipment, characterId: String)
    fun getEquipmentForCharacter(characterId: String): Flow<List<Equipment>>
}