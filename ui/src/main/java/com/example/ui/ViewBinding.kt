package com.example.ui

import androidx.lifecycle.LifecycleOwner

open class ViewBinding (lifecycleOwner: LifecycleOwner){
    private val viewBindingObserver = ViewBindingObserver(lifecycleOwner)
    protected fun <T> ifReady(block: () -> T) : T {
        return viewBindingObserver.ifReady(block)
    }
}