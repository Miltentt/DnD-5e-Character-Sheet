package com.miltent.featureCharacterCreation.fightingStyle.state

import com.miltent.core.ui.ViewState
import com.miltent.domain.model.SpecialAbility

data class FightingStyleViewState(
    val uiState: FightingStyleUiState,
    val fightingStyles: List<SpecialAbility>
) : ViewState {

    interface Factory {
        fun createEmpty(): FightingStyleViewState
    }
}