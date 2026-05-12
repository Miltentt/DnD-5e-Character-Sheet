package com.miltent.featureSkillsbase.characterSkills.di

import com.miltent.core.ui.ViewStateProvider
import com.miltent.featurecardbase.characterSkills.state.CharacterSkillsViewState
import com.miltent.featurecardbase.characterSkills.state.CharacterSkillsViewStateProvider
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
interface CharacterSkillsModule {

    @Binds
    fun bindCharacterSkillsViewStateProvider(stateProvider: CharacterSkillsViewStateProvider): ViewStateProvider<CharacterSkillsViewState>
    companion object {

        @Provides
        @CharacterSkills
        @ViewModelScoped
        fun provideJob(): Job = SupervisorJob()

        @Provides
        @CharacterSkills
        @ViewModelScoped
        fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

        @Provides
        @CharacterSkills
        @ViewModelScoped
        fun provideCoroutineScope(
            @CharacterSkills
            job: Job,
            @CharacterSkills
            dispatcher: CoroutineDispatcher,
        ) = CoroutineScope(job + dispatcher)
    }

}
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class CharacterSkills