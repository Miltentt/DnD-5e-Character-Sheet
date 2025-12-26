package com.miltent.networking.mappers.networkingToDomain

import com.miltent.core.utility.Mapper
import com.miltent.domain.model.dogs.BreedFact
import com.miltent.networking.model.BreedFactNetworking
import javax.inject.Inject

class BreedFactNetworkingToDomainMapper @Inject constructor() : Mapper<BreedFactNetworking, BreedFact> {
    override fun map(value: BreedFactNetworking): BreedFact {
        return BreedFact(
            breedId = value.breedId,
            fact = value.fact,
            id = value.id,
            title = value.title
        )
    }
}