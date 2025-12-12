package com.miltent.featurecardbase.dogs

import com.miltent.domain.model.networking.Breed
import com.miltent.domain.model.networking.DogFact

data class DogsUiState(
    val breedText: String,
    val dogBreeds: List<Breed>,
    val breedFacts: List<DogFact>?
    )