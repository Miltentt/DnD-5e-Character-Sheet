package com.miltent.domain.model.dogs

data class Breed(
    val breedFor: String?,
    val breedGroup: String,
    val id: Int,
    val image: Image,
    val lifeSpan: String,
    val name: String,
    val origin: String?,
    val referenceImageId: String,
    val temperament: String,
)