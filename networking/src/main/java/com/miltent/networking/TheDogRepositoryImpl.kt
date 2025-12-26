package com.miltent.networking

import com.miltent.core.repository.TheDogRepository
import com.miltent.core.utility.Mapper
import com.miltent.domain.model.dogs.Breed
import com.miltent.domain.model.dogs.BreedFact
import com.miltent.networking.model.BreedFactNetworking
import com.miltent.networking.model.BreedNetworking
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TheDogRepositoryImpl @Inject constructor(
    val api: TheDogApi,
    val breedMapper: Mapper<BreedNetworking, Breed>,
    val breedFactMapper: Mapper<BreedFactNetworking, BreedFact>
): TheDogRepository {

    override suspend fun getDogBreeds(breedName: String): List<Breed> {
        val apiResponse = api.getDogBreeds(breedName)
        if(apiResponse.isSuccessful) {
            val apiResponseBody = apiResponse.body() ?: throw Exception("getDogBreeds() returned null")
            return  apiResponseBody.map { breedMapper.map(it) }
        } else throw Exception("getDogBreeds() failed with ${apiResponse.code()}")
    }

    override suspend fun getDogBreedFacts(breedId: Int): List<BreedFact> {
        val apiResponse = api.getDogBreedFacts(breedId)
        if(apiResponse.isSuccessful) {
            val apiResponseBody = apiResponse.body() ?: throw Exception("getDogBreedFacts() returned null")
            return apiResponseBody.map { breedFactMapper.map(it) }
        } else throw Exception("getDogBreedFacts() failed with ${apiResponse.code()}")
    }
}