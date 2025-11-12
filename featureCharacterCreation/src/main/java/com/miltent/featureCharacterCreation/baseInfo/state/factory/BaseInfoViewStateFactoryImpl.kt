package com.miltent.featureCharacterCreation.baseInfo.state.factory

import com.miltent.domain.model.Attributes
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoUiState
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoViewState
import javax.inject.Inject

class BaseInfoViewStateFactoryImpl @Inject constructor(): BaseInfoViewState.Factory {

    override fun createEmpty(): BaseInfoViewState = BaseInfoViewState(
        uiState = BaseInfoUiState(
            name = "",
            attributesIncomplete = Attributes.attributesIncomplete,
            race = null,
            characterClass = null,
            errors = listOf()
        )
    )
}