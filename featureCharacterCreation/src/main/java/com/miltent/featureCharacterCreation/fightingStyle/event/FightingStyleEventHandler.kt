package com.miltent.featureCharacterCreation.fightingStyle.event

import com.miltent.core.event.EventHandler
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
@ViewModelScoped
internal class FightingStyleEventHandler @Inject constructor() : EventHandler<FightingStyleEvent>()