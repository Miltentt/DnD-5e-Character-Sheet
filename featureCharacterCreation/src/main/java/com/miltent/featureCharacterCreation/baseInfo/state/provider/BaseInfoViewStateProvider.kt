package com.miltent.featureCharacterCreation.baseInfo.state.provider

import com.miltent.core.ui.ViewStateProvider
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoViewState
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class BaseInfoViewStateProvider @Inject constructor(
    viewStateFactory: BaseInfoViewState.Factory
) : ViewStateProvider<BaseInfoViewState>() {

    override val _viewState: MutableStateFlow<BaseInfoViewState> =
        MutableStateFlow(viewStateFactory.createEmpty())

}