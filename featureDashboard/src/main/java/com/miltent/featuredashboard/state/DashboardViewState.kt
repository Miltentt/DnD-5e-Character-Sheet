package com.miltent.featuredashboard.state

import com.miltent.core.ui.ViewState
import com.miltent.domain.model.DashboardCharacter

sealed class DashboardViewState: ViewState {

    data object Empty: DashboardViewState()

    data class Loaded(val characterList: List<DashboardCharacter>, val uiState: DashboardUiState): DashboardViewState()
}