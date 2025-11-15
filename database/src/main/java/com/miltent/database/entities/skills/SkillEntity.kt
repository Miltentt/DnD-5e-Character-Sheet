package com.miltent.database.entities.skills

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.miltent.database.entities.skills.SkillEntity.Companion.TABLE_NAME
import com.miltent.domain.model.StatisticType

@Entity(tableName = TABLE_NAME)
data class SkillEntity(
    @ColumnInfo(name = "skillId")
    @PrimaryKey
    val id: Int,
    val statisticType: String
) {
    companion object {
        val allSkillEntities = listOf<SkillEntity>(
            SkillEntity(1, StatisticType.DEX.value),
            SkillEntity(2, StatisticType.WIS.value),
            SkillEntity(3, StatisticType.INT.value),
            SkillEntity(4, StatisticType.STR.value),
            SkillEntity(5, StatisticType.CHA.value),
            SkillEntity(6, StatisticType.INT.value),
            SkillEntity(7, StatisticType.WIS.value),
            SkillEntity(8, StatisticType.CHA.value),
            SkillEntity(9, StatisticType.INT.value),
            SkillEntity(10, StatisticType.WIS.value),
            SkillEntity(11, StatisticType.INT.value),
            SkillEntity(12, StatisticType.WIS.value),
            SkillEntity(13, StatisticType.CHA.value),
            SkillEntity(14, StatisticType.CHA.value),
            SkillEntity(15, StatisticType.INT.value),
            SkillEntity(16, StatisticType.DEX.value),
            SkillEntity(17, StatisticType.DEX.value),
            SkillEntity(18, StatisticType.WIS.value),
        )
        const val TABLE_NAME = "Skills"
    }
}
