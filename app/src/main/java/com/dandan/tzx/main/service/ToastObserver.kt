package com.dandan.tzx.main.service

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.widget.Toast
import com.dandan.tzx.App

/**
 * Created by Tanzhenxing
 * Date: 2019-09-11 10:30
 * Description:
 */
class ToastObserver : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Toast.makeText(App.application, "onDestroy", Toast.LENGTH_SHORT).show()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Toast.makeText(App.application, "onResume", Toast.LENGTH_SHORT).show()
    }
}