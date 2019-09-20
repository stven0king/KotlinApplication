package com.tzx.framework.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

/**
 * Created by Tanzhenxing
 * Date: 2019-09-20 16:49
 * Description:
 */
class ApplicationObserver(val application: AbstractApplication) : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        FConfig.application = this.application
    }
}