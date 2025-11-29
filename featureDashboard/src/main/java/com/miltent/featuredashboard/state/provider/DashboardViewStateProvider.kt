package com.miltent.featuredashboard.state.provider

import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.useCase.GetDashBoardCharactersUseCase
import com.miltent.domain.model.DashboardCharacter
import com.miltent.featuredashboard.di.Dashboard
import com.miltent.featuredashboard.state.DashboardUiState
import com.miltent.featuredashboard.state.DashboardViewState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@ViewModelScoped
internal class DashboardViewStateProvider @Inject constructor(
    private val getDashBoardCharactersUseCase: GetDashBoardCharactersUseCase,
    @Dashboard private val viewModelScope: CoroutineScope
): ViewStateProvider<DashboardViewState>() {

    override val _viewState: MutableStateFlow<DashboardViewState> =
        MutableStateFlow(DashboardViewState())

    init {
        viewModelScope.launch {
            getDashBoardCharactersUseCase.invoke().collect { dashboardCharacters: List<DashboardCharacter> ->
                _viewState.update {
                    DashboardViewState(characterList = dashboardCharacters)
                }
            }
        }
    }
}