package com.miltent.database.di

import android.content.Context
import androidx.room.Room
import com.miltent.database.Dnd5eDatabase
import com.miltent.database.dao.CharacterDao
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class) // Or another appropriate component
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): Dnd5eDatabase {
        return Room.databaseBuilder(
            appContext,
            Dnd5eDatabase::class.java,
            "dnd5eDatabase"
        ).build()
    }

    @Provides
    fun provideCharacterDao(database: Dnd5eDatabase): CharacterDao {
        return database.characterDao()
    }
}
