package com.example.ui

import androidx.annotation.UiThread
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class ViewBindingObserver(lifecycleOwner: LifecycleOwner) : LifecycleObserver {
    private var ready: Boolean = false
    init {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateLifecycle() {
        ready = true
    }

    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroyLifecycle() {
        ready = false
    }

    @UiThread
    internal inline fun <T>ifReady(block: () -> T) : T {
        if (ready)
            return block()
        throw IllegalStateException("Binding is not ready for use")
    }
}