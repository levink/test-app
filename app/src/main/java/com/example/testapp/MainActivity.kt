package com.example.testapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.network.HttpClientFactory
import com.example.network.HttpClientViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = MainViewBinding(this)
        val httpClient by viewModels<HttpClientViewModel> { HttpClientFactory(BuildConfig.BASE_URL) }
        val viewModel by viewModels<MainViewModel> { MainViewModelFactory(httpClient) }

        viewModel.getProgress().observe(this, {
            binding.progressBar.progress = it
        })

        viewModel.getResponse().observe(this, {
            binding.textView.text = it.Message
        })

        if (savedInstanceState == null) {
            viewModel.askHello()
        }
    }
}