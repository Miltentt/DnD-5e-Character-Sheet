package com.miltent.database.repository

import com.miltent.core.repository.CharacterRepository
import com.miltent.core.utility.Mapper
import com.miltent.database.dao.CharacterDao
import com.miltent.database.dao.SkillsDao
import com.miltent.database.dao.SpecialAbilityDao
import com.miltent.database.entities.character.CharacterEntity
import com.miltent.database.entities.junctionTables.CharacterSkillCrossJunction
import com.miltent.database.entities.junctionTables.CharacterSpecialAbilityJunction
import com.miltent.database.factory.dbToDomain.CharacterDetailedFactory
import com.miltent.domain.model.Character
import com.miltent.domain.model.CharacterDetailed
import com.miltent.domain.model.DashboardCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val characterDao: CharacterDao,
    private val skillsDao: SkillsDao,
    private val specialAbilityDao: SpecialAbilityDao,
    private val characterEntityToDomainMapper: Mapper<CharacterEntity, Character>,
    private val characterDomainToEntityMapper: Mapper<Character, CharacterEntity>,
    private val characterDetailedFactory: CharacterDetailedFactory,
) : CharacterRepository {
    override fun getCharacters(): Flow<List<DashboardCharacter>> =
        characterDao.getAllCharacters().map { characterEntities ->
            characterEntities.map { characterEntity ->
                characterEntityToDomainMapper.map(characterEntity)

            }
        }

    override fun getCharacterById(id: Int): Flow<Character> =
        characterDao.getCharacterById(id).map { characterEntity ->
            characterEntityToDomainMapper.map(characterEntity)
        }

    override fun getCharacterDetailedById(id: Int, language: Locale): Flow<CharacterDetailed> =
        characterDao.getFullCharacterById(id).map { characterDetailed ->
            characterDetailedFactory.create(
                characterDetailed,
                skillsDao.getSkillTranslations(language.displayLanguage),
                specialAbilityDao.getSpecialAbilityTranslations(language.displayLanguage)
            )
        }

    override suspend fun upsertCharacter(
        character: Character,
        skillIds: List<Int>,
        specialAbilityIds: List<String>
    ) {
        val characterEntity = characterDomainToEntityMapper.map(character)
        val characterId = characterDao.upsertCharacter(characterEntity)
        val skillJunctions = skillIds.map { skillId ->
            CharacterSkillCrossJunction(characterId.toInt(), skillId)
        }
        val specialAbilityJunctions = specialAbilityIds.map { specialAbilityId ->
            CharacterSpecialAbilityJunction(characterId.toInt(), specialAbilityId)
        }
        characterDao.upsertJunctions(skillJunctions, specialAbilityJunctions)
    }
}