package com.uxstate.instantscore.data.remote.dtos.fixture_details

import com.squareup.moshi.Json

data class Player(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
)