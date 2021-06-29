package com.example.testapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.network.api.Provider

class MainActivity : AppCompatActivity() {

    private val clientProvider by viewModels<Provider>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewBinding = MainViewBinding(this)
        val viewModel by viewModels<MainViewModel> { MainViewModelFactory(clientProvider) }
        viewModel.getProgress().observe(this, {
            viewBinding.progressBar.progress = it
        })
        viewModel.getResponse().observe(this, {
            viewBinding.textView.text = it.Message
        })

        if (savedInstanceState == null) {
            viewModel.askHello()
        }
    }
}