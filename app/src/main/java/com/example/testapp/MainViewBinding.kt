package com.example.testapp

import android.app.Activity
import android.widget.ProgressBar
import android.widget.TextView

class MainViewBinding(activity: Activity) {
    val textView: TextView          = activity.findViewById(R.id.test123)
    val progressBar: ProgressBar    = activity.findViewById(R.id.progressBar)
}