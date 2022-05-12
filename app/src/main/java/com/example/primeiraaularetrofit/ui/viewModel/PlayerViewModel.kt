package com.example.primeiraaularetrofit.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.primeiraaularetrofit.data.PlayerRepository
import com.example.primeiraaularetrofit.data.dto.PlayerDTO
import com.example.primeiraaularetrofit.ui.vo.PlayerVO
import kotlinx.coroutines.launch

class PlayerViewModel : ViewModel() {
    private val repository = PlayerRepository()

    private val _playerLiveData: MutableLiveData<PlayerVO> = MutableLiveData()
    val playerLiveData: LiveData<PlayerVO> = _playerLiveData

    fun fetchPlayer() {
        viewModelScope.launch {
            val dto = repository.fetchPlayer().data.first().player
            _playerLiveData.value = convertDTOToVO(dto)
        }
    }

    private fun convertDTOToVO(dto: PlayerDTO): PlayerVO {
        return PlayerVO(
            name = dto.name,
            country = dto.country,
            position = dto.position,
            customized = "Thanks for using my app"
        )
    }
}