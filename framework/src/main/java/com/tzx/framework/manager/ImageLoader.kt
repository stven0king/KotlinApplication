package com.tzx.framework.manager

import android.app.Application
import android.widget.ImageView
import com.tzx.framework.base.FConfig

/**
 * Created by Tanzhenxing
 * Date: 2019-09-25 15:49
 * Description:
 */
object ImageLoader {
    private val context: Application? by lazy { FConfig.application }
    const val defalutIcon = "https://avatars3.githubusercontent.com/u/8221219?s=460&v=4"
    public fun load(url: String?, imageView: ImageView) {
        GlideApp.with(context!!).load(if (url.isNullOrBlank()) defalutIcon else url).into(imageView)
    }
}