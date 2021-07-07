package com.example.ui

import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

open class ViewBinding (lifecycleOwner: LifecycleOwner) {
    private val viewBindingObserver = ViewBindingObserver(lifecycleOwner)
    protected fun <T> ifReady(block: () -> T) : T {
        return viewBindingObserver.ifReady(block)
    }
}

open class FragmentViewBinding(fragment: Fragment) : ViewBinding(fragment) {
    private val view: View = fragment.requireView()
    protected fun<T> find(@IdRes id : Int): T {
        return view.findViewById(id)
    }
}

open class ActivityViewBinding(
    private val activity: AppCompatActivity
) : ViewBinding(activity) {
    protected fun<T> find(@IdRes id : Int): T {
        return activity.findViewById(id)
    }
}