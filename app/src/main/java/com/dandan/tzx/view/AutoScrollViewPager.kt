package com.dandan.tzx.view

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by Tanzhenxing
 * Date: 2020/11/6 4:41 PM
 * Description:
 */
/**
 * Created by Tanzhenxing
 * Date: 2020/8/12 6:40 PM
 * Description:可以监听MotionEvent.ACTION_DOWN:
 */
class AutoScrollViewPager : ViewPager {
    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {}

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> if (listener != null) {
                listener!!.onTouchDown()
            }
            MotionEvent.ACTION_UP -> if (listener != null) {
                listener!!.onTouchUp()
            }
            else -> {
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    private var listener: OnViewPagerTouchEvent? = null
    fun setOnViewPagerTouchEventListener(l: OnViewPagerTouchEvent?) {
        listener = l
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return super.onInterceptTouchEvent(ev)
    }

    private fun setViewPagerIntercept(flag: Boolean) {
        if (null != getParent()) {
            getParent().requestDisallowInterceptTouchEvent(flag)
        }
    }

    interface OnViewPagerTouchEvent {
        fun onTouchDown()
        fun onTouchUp()
    }
}
