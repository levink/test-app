package com.example.testapp

import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainViewBinding(activity: AppCompatActivity) {
    val textView: TextView          = activity.findViewById(R.id.textView)
    val progressBar: ProgressBar    = activity.findViewById(R.id.progressBar)
}