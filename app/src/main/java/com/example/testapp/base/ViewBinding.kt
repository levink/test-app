package com.example.testapp.base

import androidx.lifecycle.LifecycleOwner

open class ViewBinding (lifecycleOwner: LifecycleOwner){
    private val viewBindingObserver = ViewBindingObserver(lifecycleOwner)
    protected fun <T> ifReady(block: () -> T) : T {
        return viewBindingObserver.ifReady(block)
    }
}