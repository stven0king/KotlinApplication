package com.tzx.framework.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater

/**
 * Created by Tanzhenxing
 * Date: 2019-09-03 10:16
 * Description:
 */
abstract class BaseAdapter<T> constructor(context: Context) : RecyclerView.Adapter<BaseViewHolder<T>>() {
    public val context = context
    protected val mInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    constructor(context: Context, data: ArrayList<T>) : this(context) {
        mData = data
        if (mData == null) {
            mData = mutableListOf()
        }
    }

    protected var mData: MutableList<T>? = null

    public fun addData(value: List<T>) {
        if (mData == null) {
            mData = mutableListOf()
        }
        mData?.addAll(value)
    }

    public fun addItemData(value: T) {
        if (mData == null) {
            mData = mutableListOf()
        }
        mData?.add(value)
    }

    public fun clean() {
        mData?.clear()
    }

    override fun getItemCount(): Int {
        if (this.mData == null) {
            return 0
        }
        return this.mData!!.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val t = this.mData?.get(position)
        if (t != null) {
            holder.onBind(t, position)
        }
    }
}