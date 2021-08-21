package com.example.simpleapp.model

import com.squareup.moshi.Json

data class Movie(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "type")
    val type: String = "",
    @Json(name = "url")
    val url: String = "",
    var isDownloaded: Boolean = false
)
