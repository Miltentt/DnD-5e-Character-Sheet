package com.miltent.featureCharacterCreation.fightingStyle.state.factory

import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleUiState
import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleViewState
import javax.inject.Inject

class FightingStyleViewStateFactoryImpl @Inject constructor() : FightingStyleViewState.Factory {
    override fun createEmpty(): FightingStyleViewState = FightingStyleViewState(
        FightingStyleUiState(
            null,
            error = null,
        ), emptyList()
    )
}