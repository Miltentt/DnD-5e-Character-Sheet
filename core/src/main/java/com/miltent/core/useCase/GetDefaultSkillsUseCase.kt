package com.miltent.core.useCase

import com.miltent.domain.model.Skill
import javax.inject.Inject

class GetDefaultSkillsUseCase @Inject constructor() {

    operator fun invoke(): List<Skill> {
        return Skill.defaultSkillList
    }
}