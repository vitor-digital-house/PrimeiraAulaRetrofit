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

    private val tvName: TextView by lazy {
        findViewById(R.id.tv_name)
    }
    private val tvCountry: TextView by lazy {
        findViewById(R.id.tv_country)
    }
    private val tvPosition: TextView by lazy {
        findViewById(R.id.tv_position)
    }
    private val tvCustomized: TextView by lazy {
        findViewById(R.id.tv_customized)
    }
    private val progressBar: ProgressBar by lazy {
        findViewById(R.id.progress_bar)
    }

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
                    hideView(progressBar)
                    Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
                }
                is PlayerViewModel.Result.Success -> updateLayout(it.playerVO)
            }
        }
    }

    private fun updateLayout(player: PlayerVO) {
        showTextView(tvName, player.name)
        showTextView(tvCountry, player.country)
        showTextView(tvPosition, player.position)
        showTextView(tvCustomized, player.customized)
        hideView(progressBar)
    }

    private fun showLoading() {
        hideView(tvName)
        hideView(tvCountry)
        hideView(tvPosition)
        hideView(tvCustomized)
        progressBar.visibility = View.VISIBLE
    }

    private fun showTextView(tv: TextView, txt: String) {
        tv.apply {
            text = txt
            visibility = View.VISIBLE
        }
    }

    private fun hideView(view: View) {
        view.visibility = View.INVISIBLE
    }
}
