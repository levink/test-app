package com.example.testapp

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.skimap.api.SkiMapViewModel

class MainActivity : AppCompatActivity() {

    private val skiMapApi by viewModels<SkiMapViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView by lazy { findViewById(R.id.test123) }
        val progressBar: ProgressBar by lazy {findViewById(R.id.progressBar) }

        val viewModel by viewModels<MainViewModel> { MainViewModelFactory(skiMapApi) }
        viewModel.getProgress().observe(this, {
            progressBar.progress = it
        })
        viewModel.getResponse().observe(this, {
            textView.text = it.Message
        })

        if (savedInstanceState == null) {
            viewModel.askHello()
        }
    }
}