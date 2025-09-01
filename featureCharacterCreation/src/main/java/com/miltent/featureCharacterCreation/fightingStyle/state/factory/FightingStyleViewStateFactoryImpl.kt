package com.miltent.featureCharacterCreation.fightingStyle.state.factory

import com.miltent.domain.model.SpecialAbility
import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleUiState
import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleViewState
import javax.inject.Inject

class FightingStyleViewStateFactoryImpl @Inject constructor(): FightingStyleViewState.Factory {
    // todo
    override fun createEmpty(): FightingStyleViewState = FightingStyleViewState(FightingStyleUiState(
        SpecialAbility(description = "lol",name = "lol")))
}