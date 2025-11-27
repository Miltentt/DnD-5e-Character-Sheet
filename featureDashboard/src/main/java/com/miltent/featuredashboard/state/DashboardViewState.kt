package com.miltent.featuredashboard.state

import com.miltent.core.ui.ViewState
import com.miltent.domain.model.DashboardCharacter

data class DashboardViewState(
    val characterList: List<DashboardCharacter> = emptyList<DashboardCharacter>(),
    val uiState: DashboardUiState = DashboardUiState()
): ViewState
