package com.example.primeiraaularetrofit.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.primeiraaularetrofit.data.PlayerRepository
import com.example.primeiraaularetrofit.data.dto.PlayerDTO
import com.example.primeiraaularetrofit.ui.vo.PlayerVO
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

class PlayerViewModel : ViewModel() {
    private val repository = PlayerRepository()

    private val _fetchResultLiveData = MutableLiveData<Result>()
    val fetchResultLiveData: LiveData<Result> = _fetchResultLiveData

    fun fetchPlayer() {
        viewModelScope.launch {
            _fetchResultLiveData.value = Result.Loading

            try {
                val dto = repository.fetchPlayer().data.first().player
                _fetchResultLiveData.value = Result.Success(convertDTOToVO(dto))
            } catch (ex: HttpException) {
                _fetchResultLiveData.value = Result.Error
            } catch (ex: IOException) {
                _fetchResultLiveData.value = Result.Error
            }
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

    sealed class Result {
        class Success(val playerVO: PlayerVO) : Result()

        object Error : Result() {
            val msg = "Ops, algo deu errado"
        }

        object Loading : Result()
    }
}