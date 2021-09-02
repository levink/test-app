package com.example.testapp

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.ui.ViewBinding

class MainViewBinding(activity: AppCompatActivity) : ViewBinding(activity) {
    val textView1: TextView = activity.findViewById(R.id.textView)
    val textView2: TextView = activity.findViewById(R.id.textView2)
    val textView3: TextView = activity.findViewById(R.id.textView3)
    val button1: Button = activity.findViewById(R.id.button)
    val button2: Button = activity.findViewById(R.id.button2)

    val animationOne: LottieAnimationView = activity.findViewById(R.id.animation_one)
    val animationTwo: LottieAnimationView = activity.findViewById(R.id.animation_two)
}