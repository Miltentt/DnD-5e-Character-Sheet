package com.miltent.featureCharacterCreation.fightingStyle.state.factory

import com.miltent.core.useCase.GetFighterStylesUseCase
import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleUiState
import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleViewState
import javax.inject.Inject

class FightingStyleViewStateFactoryImpl @Inject constructor(
    private val getFighterStylesUseCase: GetFighterStylesUseCase
) : FightingStyleViewState.Factory {
    override fun createEmpty(): FightingStyleViewState = FightingStyleViewState(
        FightingStyleUiState(
            null,
            error = null,
        ), getFighterStylesUseCase.invoke()
    )
}