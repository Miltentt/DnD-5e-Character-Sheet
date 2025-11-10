package com.miltent.domain.model

data class Attributes(
    val values: Map<StatisticType, Attribute> =
                     StatisticType.entries.associateWith { Attribute(Attribute.BASE_VALUE) }
) {
    constructor(base:Int):this(
        StatisticType.entries.associateWith { Attribute(base) }
    )
    init {
        require(values.keys == StatisticType.entries.toSet())
        {"Attributes object need's to use all StatisticType objects"}
    }


    fun addToAttributes(other: Attributes): Attributes {
        val newValues = StatisticType.entries.associateWith {
            this.values[it] as Attribute + other.values[it] as Attribute 
        }
        return Attributes(newValues)
    }

    fun addToAttribute(type: StatisticType ,attribute: Attribute): Attributes {
        val newValues = this.values.toMutableMap()
        newValues[type] = newValues[type] as Attribute + attribute
        return Attributes(newValues.toMap())
    }

    fun updateAttribute(type: StatisticType ,attribute: Attribute): Attributes {
        val newValues = this.values.toMutableMap().also { it[type] = attribute }
        return Attributes(newValues.toMap())
    }
}

