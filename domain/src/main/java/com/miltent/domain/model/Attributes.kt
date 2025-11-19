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
        {"Attributes object needs to use all StatisticType objects"}
    }


    fun addToAttributes(other: Attributes): Attributes {
        val newValues = StatisticType.entries.associateWith {
            this.values.getValue(it) + other.values.getValue(it)
        }
        return Attributes(newValues)
    }

    fun addToAttribute(type: StatisticType ,attribute: Attribute): Attributes {
        val newValues = this.values.toMutableMap()
        newValues[type] = newValues.getValue(type) + attribute
        return Attributes(newValues.toMap())
    }

    fun updateAttribute(type: StatisticType ,attribute: Attribute): Attributes {
        val newValues = this.values.toMutableMap().also { it[type] = attribute }
        return Attributes(newValues.toMap())
    }

    companion object {
        val startAttributes: Map<StatisticType, Attribute?>
            get() = StatisticType.entries.associateWith { Attribute(Attribute.BASE_VALUE) }
        /*fun startAttributesToAttributes(
            startAttributes: Map<StatisticType, Attribute?>
        ): Attributes{
            val outputMap = Attributes().values.toMutableMap()
            startAttributes.forEach { outputMap[it.key] = checkNotNull(it.value) }
            return Attributes(outputMap)
        }*/
    }
}

