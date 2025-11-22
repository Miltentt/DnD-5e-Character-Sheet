package com.miltent.featurecardbase.characterCard.di

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.featurecardbase.characterCard.event.CharacterCardEvent
import com.miltent.featurecardbase.characterCard.event.CharacterCardEventHandler
import com.miltent.featurecardbase.characterCard.intent.CharacterCardIntent
import com.miltent.featurecardbase.characterCard.intent.CharacterCardIntentHandler
import com.miltent.featurecardbase.characterCard.state.CharacterCardViewState
import com.miltent.featurecardbase.characterCard.state.CharacterCardViewStateProvider
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
internal interface CharacterCardModule {

    @Binds
    fun bindCharacterCardIntentHandler(handler: CharacterCardIntentHandler): IntentHandler<CharacterCardIntent>

    @Binds
    fun bindCharacterCardEventHandler(handler: CharacterCardEventHandler): EventHandler<CharacterCardEvent>

    @Binds
    fun bindCharacterCardViewStateProvider(provider: CharacterCardViewStateProvider): ViewStateProvider<CharacterCardViewState>

    companion object {

        @Provides
        @CharacterCard
        @ViewModelScoped
        fun provideJob(): Job = SupervisorJob()

        @Provides
        @CharacterCard
        @ViewModelScoped
        fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

        @Provides
        @CharacterCard
        @ViewModelScoped
        fun provideCoroutineScope(
            @CharacterCard
            job: Job,
            @CharacterCard
            dispatcher: CoroutineDispatcher,
        ) = CoroutineScope(job + dispatcher)
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class CharacterCard