package com.miltent.featurecardbase.characterCard.state

import com.miltent.core.cash.CharacterCache
import com.miltent.core.ui.ViewStateProvider
import com.miltent.featurecardbase.characterCard.di.CharacterCard
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@ViewModelScoped
class CharacterCardViewStateProvider @Inject constructor(
    @CharacterCard private val viewmodelScope: CoroutineScope,
    private val characterCache: CharacterCache
) : ViewStateProvider<CharacterCardViewState>() {
    override val _viewState: MutableStateFlow<CharacterCardViewState> =
        MutableStateFlow(CharacterCardViewState(null))

    init {
        viewmodelScope.launch{
            characterCache.characterCache.collect { characterCache ->
                updateState(viewState.value.copy(characterCache)
            ) }
        }
    }
}