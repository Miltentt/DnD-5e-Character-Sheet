package com.miltent.featureCharacterCreation.skills.event

import com.miltent.core.event.EventHandler
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
internal class SkillsEventHandler @Inject constructor() : EventHandler<SkillsEvent>()