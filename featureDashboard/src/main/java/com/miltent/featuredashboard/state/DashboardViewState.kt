package com.miltent.featuredashboard.state

import com.miltent.core.ui.ViewState

sealed class DashboardViewState: ViewState {

    data object Empty: DashboardViewState()

    data class Loaded(characterList: List<DashBoardCharacter>): DashboardViewState()
}