package com.example.testapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val factory = UserViewModelFactory(SkiMapService)
        val viewModel by viewModels<UserViewModel> { factory }
        viewModel.getProp().observe(this, { value ->
            val tv = this.findViewById<TextView>(R.id.test123)
            tv.text = value
        })

        if (savedInstanceState == null) {
            viewModel.askHello()
        }
    }
}