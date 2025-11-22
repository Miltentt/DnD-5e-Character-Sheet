package com.miltent.core.cash

import kotlinx.coroutines.flow.MutableStateFlow
import com.miltent.domain.model.Character
import kotlinx.coroutines.flow.StateFlow

object CharacterCash {
    private val _characterCash: MutableStateFlow<Character?> = MutableStateFlow(null)
    val characterCash: StateFlow<Character?> = _characterCash
    fun update(character: Character){
            _characterCash.value = character
    }
}