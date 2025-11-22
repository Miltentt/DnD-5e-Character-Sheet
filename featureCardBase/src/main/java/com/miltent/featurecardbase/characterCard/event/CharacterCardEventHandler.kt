package com.miltent.featurecardbase.characterCard.event

import com.miltent.core.event.EventHandler
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CharacterCardEventHandler @Inject constructor() : EventHandler<CharacterCardEvent>() {
}