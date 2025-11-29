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
import com.miltent.database.mapper.domainToDb.CharacterDomainToEntityMapper
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

    override suspend fun deleteCharacterWithJunctions(id: String) {
        characterDao.deleteCharacter(id)
    }

    override fun getCharacterById(id: String): Flow<Character> =
        characterDao.getCharacterById(id).map { characterEntity ->
            characterEntityToDomainMapper.map(characterEntity)
        }

    override fun getCharacterDetailedById(id: String, language: Locale): Flow<CharacterDetailed> =
        characterDao.getFullCharacterById(id).map { characterDetailed ->
            characterDetailedFactory.create(
                characterDetailed,
                skillsDao.getSkillTranslations(language.displayLanguage),
                specialAbilityDao.getSpecialAbilitiesTranslations(language.displayLanguage)
            )
        }

    override suspend fun upsertCharacter(
        character: Character,
        skillIds: List<Int>,
        specialAbilityIds: List<String>
    ) {

        val skillJunctions = skillIds.map { skillId ->
            CharacterSkillCrossJunction(character.id, skillId)
        }
        val specialAbilityJunctions = specialAbilityIds.map { specialAbilityId ->
            CharacterSpecialAbilityJunction(character.id, specialAbilityId)
        }
        characterDao.upsertCharacter(characterDomainToEntityMapper.map(character))
        characterDao.upsertJunctions(skillJunctions, specialAbilityJunctions)
    }
}