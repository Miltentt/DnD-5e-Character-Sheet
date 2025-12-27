package com.miltent.core.repository

import com.miltent.domain.model.dogs.Breed
import com.miltent.domain.model.dogs.BreedFact

interface TheDogRepository {

    suspend fun getDogBreeds(breedName: String): List<Breed>
    suspend fun getDogBreedFacts(breedId: Int) : List<BreedFact>
}