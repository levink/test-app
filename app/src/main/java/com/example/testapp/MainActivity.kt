package com.example.testapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.skimap.api.SkiMapViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = getUserViewModel()
        val textView: TextView by lazy { findViewById(R.id.test123) }
        viewModel.getResponse().observe(this, { helloResponse ->
            textView.text = helloResponse.Message
        })

        if (savedInstanceState == null) {
            viewModel.askHello()
        }
    }

    private fun getUserViewModel() : UserViewModel {
        val skiMap by viewModels<SkiMapViewModel>()
        val viewModel by viewModels<UserViewModel> {
            UserViewModelFactory(skiMap)
        }
        return viewModel
    }
}