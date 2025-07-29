package com.miltent.featureCharacterCreation.fightingStyle.state

import com.miltent.core.ui.ViewState

data class FightingStyleViewState(val uiState: FightingStyleUiState) : ViewState {

    interface Factory {
        fun createEmpty(): FightingStyleViewState
    }
}