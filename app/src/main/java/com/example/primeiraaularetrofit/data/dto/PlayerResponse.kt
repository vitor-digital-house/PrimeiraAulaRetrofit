package com.example.primeiraaularetrofit.data.dto

import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @SerializedName("Object")
    val data: List<DataDTO>,
)
