package com.miltent.networking.model

import com.squareup.moshi.Json

data class ImageNetworking(
    @Json(name = "height") val height: Int,
    @Json(name = "id") val id: String,
    @Json(name = "url") val url: String,
    @Json(name = "width") val width: Int
)