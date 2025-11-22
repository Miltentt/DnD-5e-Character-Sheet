package com.miltent.featurecardbase.di

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.featurecardbase.characterCard.state.CharacterCardViewState
import com.miltent.featurecardbase.characterCard.state.CharacterCardViewStateProvider
import com.miltent.featurecardbase.event.CardBaseEvent
import com.miltent.featurecardbase.event.CardBaseEventHandler
import com.miltent.featurecardbase.intent.CardBaseIntent
import com.miltent.featurecardbase.intent.CardBaseIntentHandler
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
internal interface CardBaseModule {

    @Binds
    fun bindCardBaseIntentHandler(handler: CardBaseIntentHandler): IntentHandler<CardBaseIntent>

    @Binds
    fun bindCardBaseEventHandler(handler: CardBaseEventHandler): EventHandler<CardBaseEvent>

    @Binds
    fun bindCharacterCardViewStateProvider(provider: CharacterCardViewStateProvider): ViewStateProvider<CharacterCardViewState>

    companion object {

        @Provides
        @CardBase
        @ViewModelScoped
        fun provideJob(): Job = SupervisorJob()

        @Provides
        @CardBase
        @ViewModelScoped
        fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

        @Provides
        @CardBase
        @ViewModelScoped
        fun provideCoroutineScope(
            @CardBase
            job: Job,
            @CardBase
            dispatcher: CoroutineDispatcher,
        ) = CoroutineScope(job + dispatcher)
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class CardBase

