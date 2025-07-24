package com.miltent.featureCharacterCreation.baseInfo.state.factory

import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoUiState
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoViewState
import javax.inject.Inject

class BaseInfoViewStateFactoryImpl @Inject constructor(): BaseInfoViewState.Factory {

    override fun createEmpty(): BaseInfoViewState = BaseInfoViewState(
        uiState = BaseInfoUiState(
            name = "",
            strength = 0,
            dexterity = 0,
            constitution = 0,
            intelligence = 0,
            wisdom = 0,
            charisma = 0,
            race = null,
            characterClass = null
        )
    )
}