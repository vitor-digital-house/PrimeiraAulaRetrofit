package com.example.primeiraaularetrofit.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.primeiraaularetrofit.R
import com.example.primeiraaularetrofit.ui.viewModel.PlayerViewModel

class PlayerActivity : AppCompatActivity() {

    private val viewModel: PlayerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
