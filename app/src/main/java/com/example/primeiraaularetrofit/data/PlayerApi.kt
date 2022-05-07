package com.example.primeiraaularetrofit.data

import com.example.primeiraaularetrofit.data.dto.PlayerResponse
import retrofit2.http.GET

interface PlayerApi {

    @GET("teste/teste.json")
    suspend fun fetchPlayer(): PlayerResponse

}