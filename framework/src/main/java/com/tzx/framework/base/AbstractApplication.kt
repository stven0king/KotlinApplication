package com.tzx.framework.base

import android.app.Application
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry

/**
 * Created by Tanzhenxing
 * Date: 2019-09-20 16:38
 * Description:
 */
open class AbstractApplication : Application() , LifecycleOwner {
    protected val lifecycle = LifecycleRegistry(this)
    override fun getLifecycle(): Lifecycle = lifecycle

    override fun onCreate() {
        super.onCreate()
        lifecycle.markState(Lifecycle.State.CREATED)
    }

    protected fun addObserver(observer: LifecycleObserver) {
        getLifecycle().addObserver(observer)
    }

    override fun onTerminate() {
        super.onTerminate()
        lifecycle.markState(Lifecycle.State.DESTROYED)
    }

}