package com.miltent.core.utility

interface Mapper<V,K> {
    fun map(value: V): K
}