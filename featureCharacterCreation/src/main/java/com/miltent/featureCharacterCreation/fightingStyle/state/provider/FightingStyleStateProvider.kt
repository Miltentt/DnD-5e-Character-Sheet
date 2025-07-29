package com.miltent.featureCharacterCreation.fightingStyle.state.provider

import com.miltent.core.ui.ViewStateProvider
import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleViewState
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class FightingStyleStateProvider @Inject constructor(
    viewStateFactory: FightingStyleViewState.Factory
) : ViewStateProvider<FightingStyleViewState>() {

    override val _viewState: MutableStateFlow<FightingStyleViewState> =
        MutableStateFlow(viewStateFactory.createEmpty())

}