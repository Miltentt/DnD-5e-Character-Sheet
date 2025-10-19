package com.miltent.core.repository

import com.miltent.domain.model.Skill

interface SkillsRepository {

    suspend fun getAllSkills(language: String): List<Skill>
}