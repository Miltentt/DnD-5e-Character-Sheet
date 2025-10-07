package com.miltent.featureCharacterCreation.fightingStyle.state.provider

import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.useCase.GetFighterStylesUseCase
import com.miltent.featureCharacterCreation.fightingStyle.di.FightingStyle
import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleViewState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@ViewModelScoped
class FightingStyleStateProvider @Inject constructor(
    viewStateFactory: FightingStyleViewState.Factory,
    @FightingStyle private val viewmodelScope: CoroutineScope,
    private val getFighterStylesUseCase: GetFighterStylesUseCase
) : ViewStateProvider<FightingStyleViewState>() {

    override val _viewState: MutableStateFlow<FightingStyleViewState> =
        MutableStateFlow(viewStateFactory.createEmpty())

    init {
        viewmodelScope.launch {
            _viewState.update {
                viewState.value.copy(
                    fightingStyles = getFighterStylesUseCase.invoke()
                )
            }
        }
    }
}