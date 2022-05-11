package com.example.primeiraaularetrofit.ui.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.primeiraaularetrofit.R
import com.example.primeiraaularetrofit.ui.viewModel.PlayerViewModel
import kotlinx.coroutines.launch

class PlayerActivity : AppCompatActivity() {

    private val viewModel: PlayerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupLayout()
    }

    private fun setupLayout() {
        lifecycleScope.launch {
            val response = viewModel.fetchPlayer()
            val player = response.data.first().player

            findViewById<TextView>(R.id.tv_name).text = player.name
            findViewById<TextView>(R.id.tv_country).text = player.country
            findViewById<TextView>(R.id.tv_position).text = player.position
        }
    }
}
