package com.miltent.networking

import com.miltent.domain.model.networking.Breed
import com.miltent.domain.model.networking.DogFact
import com.miltent.networking.util.BASE_BREEDS_END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheDogApi {

    @GET(BASE_BREEDS_END_POINT + "search")
    suspend fun getDogBreeds(
        @Query("q") breedName: String
    ): Response<List<Breed>>

    @GET(BASE_BREEDS_END_POINT + "{breed_id}/facts")
    suspend fun getDogBreedFacts(
        @Path("breed_id") breed_id: Int
    ): Response<List<DogFact>>
}