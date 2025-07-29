package com.miltent.domain.di

import com.miltent.domain.builder.Character1stLevelBuilderImpl
import com.miltent.domain.model.Character
import dagger.Binds
import dagger.Module

@Module
interface BuilderModule {

    @Binds
    fun bindCharacter1stLevelBuilder(builder: Character1stLevelBuilderImpl): Character.Builder1stLevel
}