package com.miltent.database.mapper.dbToDomain

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.RaceEntity
import com.miltent.domain.model.Race
import javax.inject.Inject

class RaceDbToDomainMapper @Inject constructor(): Mapper<RaceEntity, Race> {
    override fun map(value: RaceEntity): Race = when(value.raceIdentifier) {
        Race.Dwarf.identifier -> Race.Dwarf
        else -> throw IllegalArgumentException("Unknown race: ${value.raceIdentifier}")
    }
}