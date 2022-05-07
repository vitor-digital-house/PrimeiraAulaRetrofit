package com.example.primeiraaularetrofit.data.dto

import com.google.gson.annotations.SerializedName

data class DataDTO(
    @SerializedName("Player")
    val player: PlayerDTO,
)