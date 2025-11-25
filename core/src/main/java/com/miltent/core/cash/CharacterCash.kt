package com.miltent.core.cash

import com.miltent.core.useCase.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import com.miltent.domain.model.Character
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterCash @Inject constructor(val getCharacterUseCase: GetCharacterUseCase) {

    private val _characterCash: MutableStateFlow<Character?> = MutableStateFlow(null)

    val characterCash: StateFlow<Character?> = _characterCash

    suspend fun update(characterId: String){
        getCharacterUseCase.invoke(characterId).collect {
            character ->  _characterCash.value = character }
    }
}