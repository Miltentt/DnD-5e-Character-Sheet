package com.miltent.core.repository

import com.miltent.domain.model.networking.Breed
import com.miltent.domain.model.networking.DogFact

interface TheDogRepository {

    suspend fun getDogBreeds(breedName: String): List<Breed>
    suspend fun getDogBreedFacts(breedId: Int) : List<DogFact>
}