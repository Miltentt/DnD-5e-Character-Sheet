package com.miltent.featuredashboard.event

import com.miltent.core.event.EventHandler
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
internal class DashboardEventHandler @Inject constructor(): EventHandler<DashboardEvent>()