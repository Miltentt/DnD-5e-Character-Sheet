package com.miltent.core.useCase

import com.miltent.core.repository.TheDogRepository
import javax.inject.Inject

class GetBreedsUseCase @Inject constructor(val repository: TheDogRepository) {

    suspend operator fun invoke(breedId: String) = repository.getDogBreeds(breedId)
}