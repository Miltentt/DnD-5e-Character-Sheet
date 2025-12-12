package com.miltent.networking

import com.miltent.core.repository.TheDogRepository
import com.miltent.domain.model.networking.Breed
import com.miltent.domain.model.networking.DogFact
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TheDogRepositoryImpl @Inject constructor(val api: TheDogApi): TheDogRepository {

    override suspend fun getDogBreeds(breedName: String): List<Breed> {
        val apiResponse = api.getDogBreeds(breedName)
        if(apiResponse.isSuccessful) {
            return  apiResponse.body() ?: throw Exception("getDogBreeds() returned null")
        } else throw Exception("getDogBreeds() failed with ${apiResponse.code()}")
    }

    override suspend fun getDogBreedFacts(breedId: Int): List<DogFact> {
        val apiResponse = api.getDogBreedFacts(breedId)
        if(apiResponse.isSuccessful) {
            return  apiResponse.body() ?: throw Exception("getDogBreedFacts() returned null")
        } else throw Exception("${apiResponse.code()}")
    }
}