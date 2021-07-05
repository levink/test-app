package com.example.testapp

import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ui.ViewBinding

class MainViewBinding(activity: AppCompatActivity) : ViewBinding(activity) {
    val textView: TextView = activity.findViewById(R.id.textView)
        get() = ifReady { field }

    val progressBar: ProgressBar = activity.findViewById(R.id.progressBar)
        get() = ifReady { field }
}