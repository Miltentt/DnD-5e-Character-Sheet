package com.miltent.database.mapper.DbToDomain

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.AttributeEntity
import com.miltent.domain.model.Attribute
import javax.inject.Inject

class AttributeDbToDomainMapper @Inject constructor(): Mapper<AttributeEntity, Attribute> {
    override fun map(value: AttributeEntity): Attribute = Attribute(
        value = value.value,
    )
}