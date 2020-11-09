package com.tzx.framework.utils

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.util.DisplayMetrics

/**
 * Created by Tanzhenxing
 * Date: 2020/11/6 5:09 PM
 * Description:
 */
object ScreenUtils {
    /**
     * 当前屏幕方向
     *
     * @param activity
     * @return
     */
    fun getOrientation(activity: Activity): Int {
        return activity.resources.configuration.orientation
    }

    /**
     * 当前屏幕方向是横向？
     *
     * @param activity
     * @return
     */
    fun isLandscape(activity: Activity): Boolean {
        return getOrientation(activity) == Configuration.ORIENTATION_LANDSCAPE
    }

    /**
     * 当前屏幕方向是纵向？
     *
     * @param activity
     * @return
     */
    fun isPortrait(activity: Activity): Boolean {
        return getOrientation(activity) == Configuration.ORIENTATION_PORTRAIT
    }

    /**
     * densityDpi 屏幕密度DPI＿120 / 160 / 240 / 320 / 480＿
     * density 屏幕密度 0.75 / 1.0 / 1.5
     * scaledDensity sp的密度 0.75 / 1.0 / 1.5
     *
     * @return
     */
    fun getDisplayMetrics(context: Context): DisplayMetrics {
        return context.applicationContext.resources.displayMetrics
    }

    /**
     * 屏幕宽
     *
     * @return
     */
    fun getWidthPixels(context: Context): Int {
        return getDisplayMetrics(context).widthPixels
    }

    /**
     * 屏幕高
     *
     * @return
     */
    fun getHeightPixels(context: Context): Int {
        return getDisplayMetrics(context).heightPixels
    }

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    fun dp2px(context: Context, dpValue: Float): Int {
        val scale = getDisplayMetrics(context).density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun sp2px(context: Context, spValue: Float): Int {
        val fontScale = getDisplayMetrics(context).scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    fun px2dp(context: Context, pxValue: Float): Int {
        val scale = getDisplayMetrics(context).density
        return (pxValue / scale + 0.5f).toInt()
    }
}