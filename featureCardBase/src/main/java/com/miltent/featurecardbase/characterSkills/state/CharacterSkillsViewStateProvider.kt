package com.miltent.featurecardbase.characterSkills.state

import com.miltent.core.cache.CharacterCache
import com.miltent.core.ui.ViewStateProvider
import com.miltent.featureSkillsbase.characterSkills.di.CharacterSkills
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterSkillsViewStateProvider @Inject constructor(
    @CharacterSkills private val viewmodelScope: CoroutineScope,
    private val characterCache: CharacterCache
) : ViewStateProvider<CharacterSkillsViewState>() {

    override val _viewState: MutableStateFlow<CharacterSkillsViewState> = MutableStateFlow(
        CharacterSkillsViewState(emptyList())
    )

    init {
        viewmodelScope.launch {
            characterCache.characterSkills.collect { skills -> updateState(CharacterSkillsViewState(skills ?: emptyList())) }
        }
    }
}