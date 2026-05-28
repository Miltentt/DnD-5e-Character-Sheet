package com.miltent.database.repository

import com.miltent.core.repository.EquipmentRepository
import com.miltent.core.utility.Mapper
import com.miltent.database.dao.EquipmentDao
import com.miltent.database.entities.equipment.EquipmentEntity
import com.miltent.database.entities.junctionTables.CharacterEquipmentJunction
import com.miltent.domain.model.Equipment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EquipmentRepositoryImpl @Inject constructor(
    val equipmentDao: EquipmentDao,
    val mapperDomainToEntity: Mapper<Equipment, EquipmentEntity>,
    val mapperEntityToDomain: Mapper<EquipmentEntity, Equipment>
) : EquipmentRepository {

    override suspend fun insertEquipmentWithJunction(
        equipment: Equipment,
        characterId: String,
    ) {
        return equipmentDao.insertEquipmentWithJunction(
            mapperDomainToEntity.map(equipment),
            CharacterEquipmentJunction(equipmentId = equipment.id, characterId = characterId)
        )
    }

    override fun getEquipmentForCharacter(characterId: String): Flow<List<Equipment>> {
        return equipmentDao.getEquipmentForCharacter()
            .map { list -> list.map { mapperEntityToDomain.map(it) } }
    }
}