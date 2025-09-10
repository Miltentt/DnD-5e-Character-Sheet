package com.miltent.database.mapper.domainToDb

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.RaceEntity
import com.miltent.domain.model.Race
import javax.inject.Inject

class RaceDomainToDbMapper @Inject constructor() : Mapper<Race, RaceEntity> {
    override fun map(value: Race): RaceEntity = RaceEntity(
        raceIdentifier = value.identifier
    )
}