package com.miltent.featureCharacterCreation.fightingStyle.di

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.featureCharacterCreation.fightingStyle.event.FightingStyleEvent
import com.miltent.featureCharacterCreation.fightingStyle.event.FightingStyleEventHandler
import com.miltent.featureCharacterCreation.fightingStyle.intent.FightingStyleIntent
import com.miltent.featureCharacterCreation.fightingStyle.intent.FightingStyleIntentHandler
import com.miltent.featureCharacterCreation.fightingStyle.state.FightingStyleViewState
import com.miltent.featureCharacterCreation.fightingStyle.state.factory.FightingStyleViewStateFactoryImpl
import com.miltent.featureCharacterCreation.fightingStyle.state.provider.FightingStyleStateProvider
import com.miltent.featureCharacterCreation.fightingStyle.validation.FightingStyleValidator
import com.miltent.featureCharacterCreation.fightingStyle.validation.FightingStyleValidatorImpl
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
internal interface FightingStyleModule {

    @Binds
    fun bindFightingStyleEventHandler(handler: FightingStyleEventHandler): EventHandler<FightingStyleEvent>

    @Binds
    fun bindFightingStyleIntentHandler(handler: FightingStyleIntentHandler): IntentHandler<FightingStyleIntent>

    @Binds
    fun bindFightingStyleViewStateProvider(provider: FightingStyleStateProvider): ViewStateProvider<FightingStyleViewState>

    @Binds
    fun bindFightingStyleViewStateFactory(factory: FightingStyleViewStateFactoryImpl): FightingStyleViewState.Factory

    @Binds
    fun bindFightingStyleValidator(validator: FightingStyleValidatorImpl): FightingStyleValidator

    companion object {
        @Provides
        @FightingStyle
        @ViewModelScoped
        fun provideJob(): Job = SupervisorJob()

        @Provides
        @FightingStyle
        @ViewModelScoped
        fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

        @Provides
        @FightingStyle
        @ViewModelScoped
        fun provideCoroutineScope(
            @FightingStyle
            job: Job,
            @FightingStyle
            dispatcher: CoroutineDispatcher,
        ) = CoroutineScope(job + dispatcher)
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FightingStyle
