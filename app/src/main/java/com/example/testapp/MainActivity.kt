package com.example.testapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.network.api.ApiClientViewModel
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val clientProvider by viewModels<ApiClientViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel by viewModels<MainViewModel> { MainViewModelFactory(clientProvider) }
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