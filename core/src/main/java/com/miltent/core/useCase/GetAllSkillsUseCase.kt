package com.miltent.core.useCase

import android.content.Context
import com.miltent.core.repository.SkillsRepository
import com.miltent.domain.model.Skill
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetAllSkillsUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val skillsRepository: SkillsRepository
) {

    suspend operator fun invoke(): List<Skill> {
        val locale = context.resources.configuration.locales[0]
        return skillsRepository.getAllSkills(locale.language)
    }
}