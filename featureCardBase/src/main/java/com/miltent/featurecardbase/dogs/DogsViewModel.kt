package com.miltent.featurecardbase.dogs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miltent.core.repository.TheDogRepository
import com.miltent.domain.model.networking.Breed
import com.miltent.domain.model.networking.DogFact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class DogsViewModel @Inject constructor(
    val theDogRepository: TheDogRepository
): ViewModel() {

    private val _breedText = MutableStateFlow("")
    val breedText = _breedText.asStateFlow()
    private val _dogBreeds = MutableStateFlow<List<Breed>>(emptyList())
    val dogBreeds = _dogBreeds.asStateFlow()
    private var _breedFacts = MutableStateFlow<List<DogFact>?>(null)
    val breedFacts = _breedFacts.asStateFlow()
    fun changeText(newText: String){
        _breedText.value = newText
    }
    fun searchDogBreeds(){
        viewModelScope.launch {
            _dogBreeds.value = theDogRepository.getDogBreeds(breedText.value)
        }
    }
    fun searchBreedFacts(breedId: Int?){
        if (breedId == null) {
            _breedFacts.value = null
        } else {
            viewModelScope.launch {
                _breedFacts.value = theDogRepository.getDogBreedFacts(breedId)
            }
        }
    }
}