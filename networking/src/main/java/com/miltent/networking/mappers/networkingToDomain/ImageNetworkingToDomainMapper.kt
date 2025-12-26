package com.miltent.networking.mappers.networkingToDomain

import com.miltent.core.utility.Mapper
import com.miltent.domain.model.dogs.Image
import com.miltent.networking.model.ImageNetworking
import javax.inject.Inject

class ImageNetworkingToDomainMapper @Inject constructor() : Mapper<ImageNetworking, Image> {
    override fun map(value: ImageNetworking): Image {
        return Image(
            height = value.height,
            id = value.id,
            url = value.url,
            width = value.width
        )
    }
}