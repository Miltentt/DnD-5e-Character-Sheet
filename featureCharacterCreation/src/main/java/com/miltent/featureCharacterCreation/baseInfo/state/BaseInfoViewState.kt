package com.miltent.featureCharacterCreation.baseInfo.state

import com.miltent.core.ui.ViewState

data class BaseInfoViewState(val uiState: BaseInfoUiState): ViewState {

    interface Factory {
        fun createEmpty(): BaseInfoViewState
    }
}
