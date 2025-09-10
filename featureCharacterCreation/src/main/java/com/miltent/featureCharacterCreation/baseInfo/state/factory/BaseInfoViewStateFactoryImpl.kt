package com.miltent.featureCharacterCreation.baseInfo.state.factory

import com.miltent.domain.model.Attribute
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoUiState
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoViewState
import javax.inject.Inject

class BaseInfoViewStateFactoryImpl @Inject constructor(): BaseInfoViewState.Factory {

    override fun createEmpty(): BaseInfoViewState = BaseInfoViewState(
        uiState = BaseInfoUiState(
            name = "",
            strength = Attribute(0),
            dexterity = Attribute(0),
            constitution =Attribute(0),
            intelligence = Attribute(0),
            wisdom = Attribute(0),
            charisma = Attribute(0),
            race = null,
            characterClass = null,
            error = null,
        )
    )
}