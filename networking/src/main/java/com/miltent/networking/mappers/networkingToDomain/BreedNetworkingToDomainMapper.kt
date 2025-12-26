package com.miltent.networking.mappers.networkingToDomain

import com.miltent.core.utility.Mapper
import com.miltent.domain.model.dogs.Breed
import com.miltent.networking.model.BreedNetworking
import javax.inject.Inject

class BreedNetworkingToDomainMapper @Inject constructor(val imageMapper: ImageNetworkingToDomainMapper) : Mapper<BreedNetworking, Breed> {
    override fun map(value: BreedNetworking): Breed {
        return Breed(
            breedFor = value.breedFor,
            breedGroup = value.breedGroup,
            id = value.id,
            image = imageMapper.map(value.image),
            lifeSpan = value.lifeSpan,
            name = value.name,
            origin = value.origin,
            referenceImageId = value.referenceImageId,
            temperament = value.temperament,
        )
    }
}