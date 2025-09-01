package com.miltent.database.mapper.domainToDb

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.MovementSpeedEntity
import com.miltent.database.entities.RaceEntity
import com.miltent.database.entities.SpecialAbilityEntity
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.Race
import com.miltent.domain.model.SpecialAbility
import javax.inject.Inject

class RaceDomainToDbMapper @Inject constructor(
    private val movementSpeedDomainToDbMapper: Mapper<MovementSpeed, MovementSpeedEntity>,
    private val specialAbilityDomainToDbMapper: Mapper<SpecialAbility, SpecialAbilityEntity>
): Mapper<Race, RaceEntity> {
    override fun map(value: Race): RaceEntity = RaceEntity(
        extraModifierStrength = value.extraModifierStrength,
        extraModifierDex = value.extraModifierDex,
        extraModifierCon = value.extraModifierCon,
        extraModifierInt = value.extraModifierInt,
        extraModifierWis = value.extraModifierWis,
        extraModifierCha = value.extraModifierCha,
        specialAbility = value.specialAbility?.map { specialAbilityDomainToDbMapper.map(it) },
        movementSpeed = movementSpeedDomainToDbMapper.map(value.movementSpeed)
    )
}