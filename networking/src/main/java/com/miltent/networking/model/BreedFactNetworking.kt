package com.miltent.networking.model

import com.squareup.moshi.Json

data class BreedFactNetworking(
    @Json(name = "breed_id") val breedId: String,
    @Json(name = "fact") val fact: String,
    @Json(name = "id") val id: String,
    @Json(name = "title") val title: String
)