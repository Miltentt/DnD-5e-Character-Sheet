package com.miltent.database.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.miltent.core.repository.CharacterRepository
import com.miltent.core.repository.SkillsRepository
import com.miltent.core.repository.SpecialAbilityRepository
import com.miltent.database.Dnd5eDatabase
import com.miltent.database.dao.CharacterDao
import com.miltent.database.dao.SkillsDao
import com.miltent.database.dao.SpecialAbilityDao
import com.miltent.database.domainToDb.SkillTranslationEntitiesFactory
import com.miltent.database.entities.skills.SkillEntity
import com.miltent.database.repository.CharacterRepositoryImpl
import com.miltent.database.repository.SkillsRepositoryImpl
import com.miltent.database.repository.SpecialAbilityRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

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

            lateinit var appDatabase: Dnd5eDatabase

            appDatabase = Room.databaseBuilder(
                appContext,
                Dnd5eDatabase::class.java,
                "dnd5eDatabase",
            )
                .addCallback(object : RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(SupervisorJob() + Dispatchers.IO)
                            .launch{
                            appDatabase.skillsDao().insertAllSkillsWithTranslations(
                                SkillEntity.allSkillEntities,
                                SkillTranslationEntitiesFactory.valuesPL)
                        }
                    }
                })
//                .createFromAsset("dnd5eCharacterDatabase.db")
                .build()
            return appDatabase
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
