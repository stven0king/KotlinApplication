package com.dandan.tzx

import com.tzx.framework.base.AbstractApplication
import com.tzx.framework.base.ApplicationObserver

/**
 * Created by Tanzhenxing
 * Date: 2018/8/22 下午7:31
 * Description:应用程序
 */

class App : AbstractApplication() {
    override fun onCreate() {
        super.onCreate()
        addObserver(ApplicationObserver(this))
    }

}