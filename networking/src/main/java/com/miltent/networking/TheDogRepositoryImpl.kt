package com.miltent.networking

import com.miltent.core.repository.TheDogRepository
import com.miltent.domain.model.networking.Breed
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TheDogRepositoryImpl @Inject constructor(val api: TheDogApi): TheDogRepository {

    override suspend fun getDogBreeds(): List<Breed> =
        api.getDogBreeds().body() ?: throw Exception("operation getDogBreeds() failed")
}