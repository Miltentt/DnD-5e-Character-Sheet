package com.miltent.featurecardbase.dogs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miltent.core.useCase.GetBreedFactsUseCase
import com.miltent.core.useCase.GetBreedsUseCase
import com.miltent.domain.model.dogs.Breed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class DogsViewModel @Inject constructor(
    val getBreedsUseCase: GetBreedsUseCase,
    val getBreedFactsUseCase: GetBreedFactsUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<DogsUiState>(
        value = DogsUiState(
            breedText = "",
            dogBreeds = emptyList(),
            breedFacts = null,
        )
    )
    val uiState = _uiState.asStateFlow()
    private val _searchEvent = MutableSharedFlow<SearchEvent>()
    val searchEvent = _searchEvent.asSharedFlow()
    fun changeText(newText: String){
        _uiState.update { uiState.value.copy(breedText = newText) }
    }

    fun searchDogBreeds() {
        viewModelScope.launch {
            try {
                val newDogBreedsValue = getBreedsUseCase.invoke(uiState.value.breedText)
                _uiState.update { uiState.value.copy(dogBreeds = newDogBreedsValue) }
                val areDogBreedsEmpty = _uiState.value.dogBreeds != emptyList<Breed>()
                _searchEvent.emit(SearchEvent.DogsSearch(areDogBreedsEmpty))

            }catch (e: Exception){
                _searchEvent.emit(SearchEvent.NetworkingError(e.message))
                null
            }
        }
    }
    fun searchBreedFacts(breedId: Int?){
        if (breedId == null) {
            _uiState.update { uiState.value.copy(breedFacts = null) }
        } else {
            viewModelScope.launch {
                val newBreedFacts =
                    try {
                        getBreedFactsUseCase.invoke(breedId)
                    } catch (e: Exception){
                        _searchEvent.emit(SearchEvent.NetworkingError(e.message))
                        null
                    }
                _uiState.update { uiState.value.copy(breedFacts = newBreedFacts) }
            }
        }
    }
}