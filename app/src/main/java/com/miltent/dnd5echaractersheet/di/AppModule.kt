package com.miltent.dnd5echaractersheet.di

import com.miltent.domain.di.DomainModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DomainModule::class])
@InstallIn(SingletonComponent::class)
interface AppModule
