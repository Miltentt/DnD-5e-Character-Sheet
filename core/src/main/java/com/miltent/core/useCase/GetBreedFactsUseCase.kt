package com.miltent.core.useCase

import com.miltent.core.repository.TheDogRepository
import javax.inject.Inject

class GetBreedFactsUseCase @Inject constructor(val repository: TheDogRepository) {

    suspend operator fun invoke(breedId: Int) = repository.getDogBreedFacts(breedId)
}