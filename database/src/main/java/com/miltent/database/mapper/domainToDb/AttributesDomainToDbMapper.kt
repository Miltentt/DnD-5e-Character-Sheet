package com.miltent.database.mapper.domainToDb

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.AttributeEntity
import com.miltent.domain.model.Attribute
import javax.inject.Inject

class AttributesDomainToDbMapper @Inject constructor(): Mapper<Attribute, AttributeEntity> {

    override fun map(value: Attribute): AttributeEntity = AttributeEntity(
        value = value.value,
    )
}