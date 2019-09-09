package com.dandan.tzx.view

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by Tanzhenxing
 * Date: 2019-09-03 22:06
 * Description:
 */
class NoScrollViewPage(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {
    public var isCanScroll = false

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        if (isCanScroll) {
            return super.onTouchEvent(ev)
        }
        return false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if (isCanScroll) {
            return super.onInterceptTouchEvent(ev)
        }
        return false
    }
}