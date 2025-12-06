package com.miltent.networking

import com.miltent.domain.model.networking.Breed
import com.miltent.networking.util.BASE_BREEDS_END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface TheDogApi {

    @GET(BASE_BREEDS_END_POINT)
    suspend fun getDogBreeds(): Response<List<Breed>>
}