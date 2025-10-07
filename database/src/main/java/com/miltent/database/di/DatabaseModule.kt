package com.miltent.database.di

import android.content.Context
import androidx.room.Room
import com.miltent.core.repository.CharacterRepository
import com.miltent.core.repository.SkillsRepository
import com.miltent.core.repository.SpecialAbilityRepository
import com.miltent.database.Dnd5eDatabase
import com.miltent.database.dao.CharacterDao
import com.miltent.database.dao.SkillsDao
import com.miltent.database.dao.SpecialAbilityDao
import com.miltent.database.repository.CharacterRepositoryImpl
import com.miltent.database.repository.SkillsRepositoryImpl
import com.miltent.database.repository.SpecialAbilityRepositoryImpl
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
    fun bindCharacterRepository(repository: CharacterRepositoryImpl): CharacterRepository

    @Binds
    fun bindSkillsRepository(repository: SkillsRepositoryImpl): SkillsRepository

    @Binds
    fun bindSpecialAbilityRepository(repository: SpecialAbilityRepositoryImpl): SpecialAbilityRepository

    companion object {
        @Provides
        @Singleton
        fun provideAppDatabase(@ApplicationContext appContext: Context): Dnd5eDatabase {
            return Room.databaseBuilder(
                appContext,
                Dnd5eDatabase::class.java,
                "dnd5eDatabase",
            )
                .createFromAsset("dnd5eCharacterDatabase.db")
                .build()
        }

        @Provides
        fun provideCharacterDao(database: Dnd5eDatabase): CharacterDao {
            return database.characterDao()
        }

        @Provides
        fun provideSkillsDao(database: Dnd5eDatabase): SkillsDao {
            return database.skillsDao()
        }

        @Provides
        fun provideSpecialAbilityDao(database: Dnd5eDatabase): SpecialAbilityDao {
            return database.specialAbilityDao()
        }
    }
}
