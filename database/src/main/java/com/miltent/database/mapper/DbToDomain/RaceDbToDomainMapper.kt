package com.miltent.database.mapper.DbToDomain

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.MovementSpeedEntity
import com.miltent.database.entities.RaceEntity
import com.miltent.database.entities.SpecialAbilityEntity
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.Race
import com.miltent.domain.model.SpecialAbility
import javax.inject.Inject

class RaceDbToDomainMapper @Inject constructor(
    private val specialAbilityDbToDomainMapper: Mapper<SpecialAbilityEntity, SpecialAbility>,
    private val movementSpeedDbToDomainMapper: Mapper<MovementSpeedEntity, MovementSpeed>
): Mapper<RaceEntity, Race> {
    override fun map(value: RaceEntity): Race = Race(
        extraModifierStrength = value.extraModifierStrength,
        extraModifierDex = value.extraModifierDex,
        extraModifierCon = value.extraModifierCon,
        extraModifierInt = value.extraModifierInt,
        extraModifierWis = value.extraModifierWis,
        extraModifierCha = value.extraModifierCha,
        specialAbility = value.specialAbility?.map(specialAbilityDbToDomainMapper::map),
        movementSpeed = movementSpeedDbToDomainMapper.map(value.movementSpeed)
    )
}