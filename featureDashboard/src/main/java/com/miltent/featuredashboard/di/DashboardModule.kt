package com.miltent.featuredashboard.di

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.featuredashboard.event.DashboardEvent
import com.miltent.featuredashboard.event.DashboardEventHandler
import com.miltent.featuredashboard.intent.DashboardIntent
import com.miltent.featuredashboard.intent.DashboardIntentHandler
import com.miltent.featuredashboard.state.DashboardViewState
import com.miltent.featuredashboard.state.provider.DashboardViewStateProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier

@Module
@InstallIn(ViewModelComponent::class)
internal interface DashboardModule {

    @Binds
    fun bindDashboardIntentHandler(handler: DashboardIntentHandler): IntentHandler<DashboardIntent>

    @Binds
    fun bindDashboardEventHandler(handler: DashboardEventHandler): EventHandler<DashboardEvent>

    @Binds
    fun bindDashboardViewStateProvider(provider: DashboardViewStateProvider): ViewStateProvider<DashboardViewState>

    companion object {
        @Provides
        @Dashboard
        @ViewModelScoped
        fun provideJob(): Job = SupervisorJob()

        @Provides
        @Dashboard
        @ViewModelScoped
        fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

        @Provides
        @Dashboard
        @ViewModelScoped
        fun provideCoroutineScope(
            @Dashboard
            job: Job,
            @Dashboard
            dispatcher: CoroutineDispatcher,
        ) = CoroutineScope(job + dispatcher)
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dashboard