package com.miltent.core.ui

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

abstract class ViewStateProvider<T: ViewState> {

    protected abstract val _viewState: MutableStateFlow<T>
    val viewState: StateFlow<T> = _viewState

    fun updateState(state: T) = _viewState.update { state }
}