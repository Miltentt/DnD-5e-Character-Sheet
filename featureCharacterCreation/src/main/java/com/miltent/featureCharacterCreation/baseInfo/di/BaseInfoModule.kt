package com.miltent.featureCharacterCreation.baseInfo.di

import com.miltent.core.event.EventHandler
import com.miltent.core.intent.IntentHandler
import com.miltent.core.ui.ViewStateProvider
import com.miltent.featureCharacterCreation.baseInfo.event.BaseInfoEvent
import com.miltent.featureCharacterCreation.baseInfo.event.BaseInfoEventHandler
import com.miltent.featureCharacterCreation.baseInfo.intent.BaseInfoIntent
import com.miltent.featureCharacterCreation.baseInfo.intent.BaseInfoIntentHandler
import com.miltent.featureCharacterCreation.baseInfo.state.BaseInfoViewState
import com.miltent.featureCharacterCreation.baseInfo.state.factory.BaseInfoViewStateFactoryImpl
import com.miltent.featureCharacterCreation.baseInfo.state.provider.BaseInfoViewStateProvider
import com.miltent.featureCharacterCreation.baseInfo.validator.BaseInfoValidator
import com.miltent.featureCharacterCreation.baseInfo.validator.BaseInfoValidatorImpl
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
interface BaseInfoModule {

    @Binds
    fun bindBaseInfoEventHandler(handler: BaseInfoEventHandler): EventHandler<BaseInfoEvent>

    @Binds
    fun bindBaseInfoIntentHandler(handler: BaseInfoIntentHandler): IntentHandler<BaseInfoIntent>

    @Binds
    fun bindViewStateProvider(provider: BaseInfoViewStateProvider): ViewStateProvider<BaseInfoViewState>

    @Binds
    fun bindViewStateFactory(factory: BaseInfoViewStateFactoryImpl): BaseInfoViewState.Factory

    @Binds
    fun bindBaseInfoValidator(validator: BaseInfoValidatorImpl): BaseInfoValidator

    companion object {
        @Provides
        @BaseInfo
        @ViewModelScoped
        fun provideJob(): Job = SupervisorJob()

        @Provides
        @BaseInfo
        @ViewModelScoped
        fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

        @Provides
        @BaseInfo
        @ViewModelScoped
        fun provideCoroutineScope(
            @BaseInfo
            job: Job,
            @BaseInfo
            dispatcher: CoroutineDispatcher,
        ) = CoroutineScope(job + dispatcher)
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class BaseInfo