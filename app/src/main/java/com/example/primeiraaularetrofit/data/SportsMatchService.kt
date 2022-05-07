package com.example.primeiraaularetrofit.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://sportsmatch.com.br/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val playerApi: PlayerApi = retrofit.create(PlayerApi::class.java)