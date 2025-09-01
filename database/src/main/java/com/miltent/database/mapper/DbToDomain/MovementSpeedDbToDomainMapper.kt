package com.miltent.database.mapper.DbToDomain

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.MovementSpeedEntity
import com.miltent.domain.model.MovementSpeed
import javax.inject.Inject

class MovementSpeedDbToDomainMapper @Inject constructor() :
    Mapper<MovementSpeedEntity, MovementSpeed> {

    override fun map(value: MovementSpeedEntity): MovementSpeed = MovementSpeed(
        value = value.value
    )
}