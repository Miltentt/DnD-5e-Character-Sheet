package com.miltent.featurecardbase.characterEquipment.di

import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.core.utility.Mapper
import com.miltent.domain.model.Equipment
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntent
import com.miltent.featurecardbase.characterEquipment.intent.CharacterEquipmentIntentHandler
import com.miltent.featurecardbase.characterEquipment.mapper.CharacterEquipmentStateToEquipmentMapper
import com.miltent.featurecardbase.characterEquipment.mapper.EquipmentToCharacterEquipmentStateMapper
import com.miltent.featurecardbase.characterEquipment.state.CharacterEquipmentState
import com.miltent.featurecardbase.characterEquipment.state.CharacterEquipmentStateProvider
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
interface CharacterEquipmentModule {

    @Binds
    fun bindViewStateProvider(provider: CharacterEquipmentStateProvider): ViewStateProvider<CharacterEquipmentState>

    @Binds
    fun bindIntentHandler(handler: CharacterEquipmentIntentHandler): IntentHandler<CharacterEquipmentIntent>

    @Binds
    fun bindEquipmentToCharacterEquipmentStateMapper(
        mapper: EquipmentToCharacterEquipmentStateMapper
    ): Mapper<Equipment, CharacterEquipmentState>

    @Binds
    fun bindCharacterEquipmentStateToEquipmentMapper(
        mapper: CharacterEquipmentStateToEquipmentMapper
    ): Mapper<CharacterEquipmentState,Equipment>


    companion object {
        @Provides
        @CharacterEquipment
        @ViewModelScoped
        fun provideJob(): Job = SupervisorJob()

        @Provides
        @CharacterEquipment
        @ViewModelScoped
        fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

        @Provides
        @CharacterEquipment
        @ViewModelScoped
        fun provideCoroutineScope(
            @CharacterEquipment
            job: Job,
            @CharacterEquipment
            dispatcher: CoroutineDispatcher,
        ) = CoroutineScope(job + dispatcher)
    }
}
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class CharacterEquipment