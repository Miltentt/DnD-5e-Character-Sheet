package com.miltent.core.cash

import com.miltent.core.useCase.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import com.miltent.domain.model.Character
import com.miltent.domain.model.Equipment
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterCache @Inject constructor(private val getCharacterUseCase: GetCharacterUseCase) {

    private val _equipmentCache: MutableStateFlow<Equipment> = MutableStateFlow(Equipment())
    val equipmentCache = _equipmentCache.asStateFlow()
    fun updateEq(eq: Equipment) {
        _equipmentCache.update { eq }
    }

    private val _characterCache: MutableStateFlow<Character?> = MutableStateFlow(null)

    val characterCache: StateFlow<Character?> = _characterCache

    suspend fun update(characterId: String) {
        getCharacterUseCase.invoke(characterId).collect { character ->
            _characterCache.value = character
        }
    }
}