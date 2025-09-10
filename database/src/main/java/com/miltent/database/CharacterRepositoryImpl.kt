package com.miltent.database

import com.miltent.core.repository.CharacterRepository
import com.miltent.core.utility.Mapper
import com.miltent.database.dao.CharacterDao
import com.miltent.database.entities.CharacterEntity
import com.miltent.domain.model.Character
import com.miltent.domain.model.DashboardCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val characterDao: CharacterDao,
    private val characterEntityToDomainMapper: Mapper<CharacterEntity, Character>,
    private val characterDomainToEntityMapper: Mapper<Character, CharacterEntity>
) : CharacterRepository {
    override suspend fun getCharacters(): Flow<List<DashboardCharacter>> =
        characterDao.getAllCharacters().map { characterEntities ->
            characterEntities.map { characterEntity ->
                characterEntityToDomainMapper.map(characterEntity)

            }
        }

    override suspend fun getCharacterById(id: Int): Flow<Character> =
        characterDao.getCharacterById(id).map { characterEntity ->
            characterEntityToDomainMapper.map(characterEntity)
        }

    override suspend fun upsertCharacter(character: Character) =
        characterDao.insertCharacter(characterDomainToEntityMapper.map(character))
}