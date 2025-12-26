package com.miltent.featurecardbase.dogs

import com.miltent.domain.model.dogs.Breed
import com.miltent.domain.model.dogs.BreedFact

data class DogsUiState(
    val breedText: String,
    val dogBreeds: List<Breed>,
    val breedFacts: List<BreedFact>?
    )