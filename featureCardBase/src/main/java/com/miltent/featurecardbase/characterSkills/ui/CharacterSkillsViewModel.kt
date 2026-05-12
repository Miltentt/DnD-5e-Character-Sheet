package com.miltent.featurecardbase.characterSkills.ui

import com.miltent.core.event.Event
import com.miltent.core.intent.Intent
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.viewmodel.BaseViewModel
import com.miltent.featureSkillsbase.characterSkills.di.CharacterSkills
import com.miltent.featurecardbase.characterSkills.state.CharacterSkillsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CharacterSkillsViewModel @Inject constructor(
    @CharacterSkills private val viewModelScope: CoroutineScope,
    viewStateProvider: ViewStateProvider<CharacterSkillsViewState>
) :
    BaseViewModel<CharacterSkillsViewState>(
        viewModelScope
    ) {

    override val event: SharedFlow<Event> = MutableSharedFlow()
    override val viewState: StateFlow<CharacterSkillsViewState> = viewStateProvider.viewState

    override fun setIntent(intent: Intent) {
        TODO("Not yet implemented")
    }
}