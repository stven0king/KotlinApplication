package com.dandan.tzx.common.utils

import android.content.Context
import android.os.Environment
import android.util.DisplayMetrics
import android.view.WindowManager
import com.dandan.tzx.App

/**
 * Created by Tanzhenxing
 * Date: 2018/8/23 下午5:18
 * Description: 工具类
 */

/**
 * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
 */
fun dip2px(context: Context, dpValue: Float): Int {
    val scale: Float = context.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}

/**
 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
 */
fun px2dip(context: Context, pxValue: Float): Int {
    val scale: Float = context.resources.displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}

fun getDisplayWidth(context: Context): Int {
    val metric = DisplayMetrics()
    val winManager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    winManager.defaultDisplay.getMetrics(metric)
    return metric.widthPixels
}

fun getDisplyHeight(context: Context): Int {
    val metric = DisplayMetrics()
    val winManager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    winManager.defaultDisplay.getMetrics(metric)
    return metric.heightPixels
}

fun getappCacheDir(): String? {
    var cachePath: String? = null
    try {
        cachePath = if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()
                || !Environment.isExternalStorageRemovable()) {
            App.application!!.getExternalFilesDir(null).path
        } else {
            App.application!!.cacheDir.path
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return cachePath
}