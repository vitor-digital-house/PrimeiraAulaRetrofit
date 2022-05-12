package com.example.primeiraaularetrofit.ui.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.primeiraaularetrofit.R
import com.example.primeiraaularetrofit.ui.viewModel.PlayerViewModel
import com.example.primeiraaularetrofit.ui.vo.PlayerVO

class PlayerActivity : AppCompatActivity() {

    private val viewModel: PlayerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupObserver()
        setupView()
    }

    private fun setupView() {
        findViewById<Button>(R.id.btn_fetch).setOnClickListener {
            viewModel.fetchPlayer()
        }
    }

    private fun setupObserver() {
        viewModel.playerLiveData.observe(this) {
            updateLayout(it)
        }
    }

    private fun updateLayout(player: PlayerVO) {
        findViewById<TextView>(R.id.tv_name).text = player.name
        findViewById<TextView>(R.id.tv_country).text = player.country
        findViewById<TextView>(R.id.tv_position).text = player.position
        findViewById<TextView>(R.id.tv_customized).text = player.customized
    }

    private fun fetchPlayer() = viewModel.fetchPlayer()
}
