package com.example.primeiraaularetrofit.data

import com.example.primeiraaularetrofit.data.dto.PlayerResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlayerRepository {

    private val api = playerApi

    suspend fun fetchPlayer(): PlayerResponse = withContext(Dispatchers.IO) {
        api.fetchPlayer()
    }
}
