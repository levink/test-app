package com.example.daggertest
import android.os.Looper
import android.view.LayoutInflater
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> Fragment.viewBinding(noinline initializer: (LayoutInflater) -> T) =
    ViewBindingPropertyDelegate(requireActivity(), initializer)


class ViewBindingPropertyDelegate<T : ViewBinding>(
    private val activity: FragmentActivity,
    private val initializer: (LayoutInflater) -> T
) : ReadOnlyProperty<FragmentActivity, T>, LifecycleObserver {
    private var _value: T? = null
    init {
        activity.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    @Suppress("Unused")
    fun onCreate() {
        if (_value == null) {
            _value = initializer(activity.layoutInflater)
        }
        activity.setContentView(_value?.root!!)
        activity.lifecycle.removeObserver(this)
    }

    @UiThread
    override fun getValue(thisRef: FragmentActivity, property: KProperty<*>): T {
        if (_value == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw IllegalThreadStateException("This cannot be called from other threads. It should be on the main thread only.")
            }
            _value = initializer(thisRef.layoutInflater)
        }
        return _value!!
    }
}