package com.miltent.core.repository

import com.miltent.domain.model.networking.Breed

interface TheDogRepository {

    suspend fun getDogBreeds(): List<Breed>
}