package com.miltent.featurecardbase.characterEquipment.state

import com.miltent.core.cash.CharacterCache
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.utility.Mapper
import com.miltent.domain.model.Equipment
import com.miltent.featurecardbase.characterEquipment.di.CharacterEquipment
import dagger.hilt.android.scopes.ViewModelScoped
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@ViewModelScoped
class CharacterEquipmentStateProvider @Inject constructor(
    characterCache: CharacterCache,
    val mapperEqToState: Mapper<Equipment, CharacterEquipmentState>,
    val mapperStateToEq: Mapper<CharacterEquipmentState, Equipment>,
    @CharacterEquipment private val viewModelScope: CoroutineScope,
) : ViewStateProvider<CharacterEquipmentState>() {
    override val _viewState: MutableStateFlow<CharacterEquipmentState> =
        MutableStateFlow(CharacterEquipmentState())

    init {
        val startingState = characterCache.equipmentCache.value.let {
            mapperEqToState.map(it)
        }
        updateState(startingState)

        viewModelScope.launch {
            viewState.collect { state ->
                characterCache.updateEq(mapperStateToEq.map(state))
            }
        }
    }
}