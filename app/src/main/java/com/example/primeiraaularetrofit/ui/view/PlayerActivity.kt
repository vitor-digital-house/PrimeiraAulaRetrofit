package com.example.primeiraaularetrofit.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.primeiraaularetrofit.R
import com.example.primeiraaularetrofit.ui.viewModel.PlayerViewModel
import com.example.primeiraaularetrofit.ui.vo.PlayerVO

class PlayerActivity : AppCompatActivity() {

    private val viewModel: PlayerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        setupObserver()
        setupView()
    }

    private fun setupView() {
        findViewById<Button>(R.id.btn_fetch).setOnClickListener {
            viewModel.fetchPlayer()
        }
    }

    private fun setupObserver() {
        viewModel.fetchResultLiveData.observe(this) {
            when (it) {
                is PlayerViewModel.Result.Loading -> {
                    showLoading()
                }
                is PlayerViewModel.Result.Error -> {
                    Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
                }
                is PlayerViewModel.Result.Success -> updateLayout(it.playerVO)
            }
        }
    }

    private fun updateLayout(player: PlayerVO) {
        findViewById<TextView>(R.id.tv_name).text = player.name
        findViewById<TextView>(R.id.tv_country).text = player.country
        findViewById<TextView>(R.id.tv_position).text = player.position
        findViewById<TextView>(R.id.tv_customized).text = player.customized
        findViewById<ProgressBar>(R.id.progress_bar).visibility = View.GONE
    }

    private fun showLoading() {
        findViewById<ProgressBar>(R.id.progress_bar).visibility = View.VISIBLE
    }
}
