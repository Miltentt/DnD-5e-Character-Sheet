package com.miltent.networking.model

import com.squareup.moshi.Json

data class BreedNetworking(
    @Json(name = "bred_for") val breedFor: String?,
    @Json(name = "breed_group") val breedGroup: String,
    @Json(name = "id") val id: Int,
    @Json(name = "image") val image: ImageNetworking,
    @Json(name = "life_span") val lifeSpan: String,
    @Json(name = "name") val name: String,
    @Json(name = "origin") val origin: String?,
    @Json(name = "reference_image_id") val referenceImageId: String,
    @Json(name = "temperament") val temperament: String
)