package com.miltent.featureCharacterCreation.skills.di

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.featureCharacterCreation.skills.event.SkillsEvent
import com.miltent.featureCharacterCreation.skills.event.SkillsEventHandler
import com.miltent.featureCharacterCreation.skills.intent.SkillsIntent
import com.miltent.featureCharacterCreation.skills.intent.SkillsIntentHandler
import com.miltent.featureCharacterCreation.skills.state.SkillsViewState
import com.miltent.featureCharacterCreation.skills.state.provider.SkillsStateProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier

@Module
@InstallIn(ViewModelComponent::class)
internal interface SkillsModule {

    @Binds
    fun bindSkillsEventHandler(handler: SkillsEventHandler): EventHandler<SkillsEvent>

    @Binds
    fun bindSkillsIntentHandler(handler: SkillsIntentHandler): IntentHandler<SkillsIntent>

    @Binds
    fun bindSkillsViewStateProvider(provider: SkillsStateProvider): ViewStateProvider<SkillsViewState>


    companion object {
        @Provides
        @Skills
        @ViewModelScoped
        fun provideJob(): Job = SupervisorJob()

        @Provides
        @Skills
        @ViewModelScoped
        fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

        @Provides
        @Skills
        @ViewModelScoped
        fun provideCoroutineScope(
            @Skills
            job: Job,
            @Skills
            dispatcher: CoroutineDispatcher,
        ) = CoroutineScope(job + dispatcher)
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Skills
