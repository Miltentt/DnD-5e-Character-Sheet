package com.miltent.database.mapper.domainToDb

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.CharacterClassEntity
import com.miltent.database.entities.MovementSpeedEntity
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.MovementSpeed
import javax.inject.Inject

class CharacterClassDomainToDbMapper @Inject constructor(
    private val movementSpeedDomainToDbMapper: Mapper<MovementSpeed, MovementSpeedEntity>
):
    Mapper<CharacterClass, CharacterClassEntity> {
    override fun map(value: CharacterClass): CharacterClassEntity = CharacterClassEntity(
        name = value.name,
        movementSpeedModifier = movementSpeedDomainToDbMapper.map(value.movementSpeedModifier),
        level = value.level
    )
}