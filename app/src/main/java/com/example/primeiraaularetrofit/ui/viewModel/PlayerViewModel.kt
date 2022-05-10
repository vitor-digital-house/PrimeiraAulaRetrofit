package com.example.primeiraaularetrofit.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.primeiraaularetrofit.data.PlayerRepository
import com.example.primeiraaularetrofit.data.dto.PlayerResponse

class PlayerViewModel : ViewModel() {
    private val repository = PlayerRepository()

    suspend fun fetchPlayer(): PlayerResponse {
        return repository.fetchPlayer()
    }
}