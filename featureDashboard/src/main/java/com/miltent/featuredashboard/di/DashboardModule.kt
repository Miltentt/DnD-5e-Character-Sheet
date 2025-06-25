package com.miltent.featuredashboard.di

import com.miltent.core.event.EventHandler
import com.miltent.featuredashboard.event.DashboardEvent
import com.miltent.featuredashboard.event.DashboardEventHandler
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
interface DashboardModule {

    @Binds
    fun bindDashboardEventHandler(handler: DashboardEventHandler): EventHandler<DashboardEvent>

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