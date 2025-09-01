package com.miltent.database.mapper.domainToDb

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.MovementSpeedEntity
import com.miltent.domain.model.MovementSpeed
import javax.inject.Inject

class MovementSpeedDomainToDbMapper @Inject constructor(): Mapper<MovementSpeed, MovementSpeedEntity> {
    override fun map(value: MovementSpeed): MovementSpeedEntity =MovementSpeedEntity(
        value = value.value
    )
}