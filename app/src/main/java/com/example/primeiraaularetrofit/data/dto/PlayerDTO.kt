package com.example.primeiraaularetrofit.data.dto

import com.google.gson.annotations.SerializedName

data class PlayerDTO(
    val name: String,
    @SerializedName("pos")
    val position: String,
    val country: String,
    @SerializedName("Barras")
    val saldoPartidas: SaldoPartidasDTO,
)
