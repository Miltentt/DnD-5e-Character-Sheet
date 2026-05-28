package com.miltent.database.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.miltent.database.entities.equipment.EquipmentEntity
import com.miltent.database.entities.junctionTables.CharacterEquipmentJunction
import kotlinx.coroutines.flow.Flow

@Dao
interface EquipmentDao {

    @Insert
    suspend fun insertEquipment(equipment: EquipmentEntity)

    @Insert
    suspend fun insertCharacterEquipmentJunction(junction: CharacterEquipmentJunction)

    @Transaction
    suspend fun insertEquipmentWithJunction(equipment: EquipmentEntity, junction: CharacterEquipmentJunction){
        insertEquipment(equipment)
        insertCharacterEquipmentJunction(junction)
    }

    @Query("SELECT * FROM ${EquipmentEntity.TABLE_NAME}")
    fun getEquipmentForCharacter(): Flow<List<EquipmentEntity>>
}