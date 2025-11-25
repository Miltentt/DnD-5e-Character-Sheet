package com.miltent.domain.model

@JvmInline
value class Attribute(val value: Int) {

    infix operator fun plus(other: Attribute): Attribute = Attribute(this.value + other.value)

    infix operator fun plus(other: Int): Attribute = Attribute(this.value + value)

    fun calculateModifier(temporaryModifier: Attribute = Attribute(0)): Int = ((this + temporaryModifier).value - 10) / 2

    companion object {
        const val BASE_VALUE = 10
        const val BASE_MODIFIER_VALUE = 0
        val baseValueRange = 3..18
        fun fromString(value: String): Attribute = Attribute(value.toIntOrNull() ?: 0)
    }
}