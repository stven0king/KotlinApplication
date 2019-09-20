package com.tzx.framework.view

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Tanzhenxing
 * Date: 2019-09-02 15:47
 * Description:
 */
open class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
    protected var itemData: T? = null
    protected var mPosition: Int = 0
    open fun onBind(i: T, p: Int) {
        this.itemData = i
        this.mPosition = p
    }
}