package com.miltent.domain.model

import kotlin.collections.forEach

class Attributes(
    val values: MutableMap<StatisticType, Attribute> =
                     StatisticType.entries.associateWith { Attribute(10) }.toMutableMap()
) {
    constructor(base:Int):this(
        StatisticType.entries.associateWith { Attribute(0) }.toMutableMap()
    )

    fun addAttributes(other: Attributes): Attributes {
        val newValues = this.values
        val otherValues = other.values
        StatisticType.entries.forEach {
            newValues[it] = newValues[it] as Attribute + otherValues[it] as Attribute
        }
        return Attributes(newValues)
    }

    fun addAttribute(type: StatisticType ,attribute: Attribute): Attributes {
        val newValues = this.values
        newValues[type] = newValues[type] as Attribute + attribute
        return Attributes(newValues)
    }
}

