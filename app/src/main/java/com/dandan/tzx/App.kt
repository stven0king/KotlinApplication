package com.dandan.tzx

import android.app.Application

/**
 * Created by Tanzhenxing
 * Date: 2018/8/22 下午7:31
 * Description:应用程序
 */

class App : Application() {
    companion object {
        var application: Application? = null
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }

}