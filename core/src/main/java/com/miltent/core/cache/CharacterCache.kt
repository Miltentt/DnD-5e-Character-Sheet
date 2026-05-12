package com.miltent.core.cache

import com.miltent.core.useCase.GetCharacterDetailedUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import com.miltent.domain.model.Character
import com.miltent.domain.model.SkillWithModifier
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterCache @Inject constructor(
    private val getCharacterDetailedUseCase: GetCharacterDetailedUseCase
) {

    private val _character: MutableStateFlow<Character?> = MutableStateFlow(null)
    val character: StateFlow<Character?> = _character
    private val _characterSkills: MutableStateFlow<List<SkillWithModifier>?> =
        MutableStateFlow(null)
    val characterSkills: StateFlow<List<SkillWithModifier>?> = _characterSkills

    suspend fun update(characterId: String) {
        getCharacterDetailedUseCase.invoke(characterId).collect { characterDetailed ->
            _character.value = characterDetailed.character
            _characterSkills.value = characterDetailed.getSkillsWithModifier()
        }
    }
}