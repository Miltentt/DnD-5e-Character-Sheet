package com.miltent.database.di

import android.content.Context
import androidx.room.Room
import com.miltent.core.repository.CharacterRepository
import com.miltent.database.CharacterRepositoryImpl
import com.miltent.database.Dnd5eDatabase
import com.miltent.database.dao.CharacterDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DatabaseModule {

    @Binds
    abstract fun bindCharacterRepository(repository: CharacterRepositoryImpl): CharacterRepository

    companion object {
        @Provides
        @Singleton
        fun provideAppDatabase(@ApplicationContext appContext: Context): Dnd5eDatabase {
            return Room.databaseBuilder(
                appContext,
                Dnd5eDatabase::class.java,
                "dnd5eDatabase",
            ).build()
        }

        @Provides
        fun provideCharacterDao(database: Dnd5eDatabase): CharacterDao {
            return database.characterDao()
        }
    }
}
