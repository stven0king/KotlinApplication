package com.dandan.tzx.view.adapter

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dandan.tzx.R
import com.tzx.framework.view.BaseAdapter
import com.tzx.framework.view.BaseViewHolder
import com.dandan.tzx.main.activity.PicPreviewActivity
import com.dandan.tzx.main.model.GankItemEntiry
import com.tzx.framework.manager.ImageLoader
import com.tzx.framework.utils.ScreenUtils
import java.util.*

/**
 * Created by Tanzhenxing
 * Date: 2019-09-02 15:41
 * Description:
 */
class FindMainAdapter(recycler: RecyclerView, context: Context) : BaseAdapter<GankItemEntiry>(context) {
    val recycler = recycler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<GankItemEntiry> {
        val view = mInflater.inflate(R.layout.item_find_layout, parent, false)
        return ViewHolder(view)
    }


    inner class ViewHolder(view: View) : BaseViewHolder<GankItemEntiry>(view) {
        val icon: ImageView = itemView!!.findViewById(R.id.icon)
        val desc: TextView = itemView!!.findViewById(R.id.desc)
        override fun onBind(i: GankItemEntiry, p: Int) {
            super.onBind(i, p)
            val layout = this@FindMainAdapter.recycler.layoutManager
            if (layout !is GridLayoutManager) {
                icon.layoutParams.height = ScreenUtils.dp2px(context, 180F)
            } else {
                icon.layoutParams.height = ScreenUtils.dp2px(context, 290F)
            }
            ImageLoader.load(itemData!!.url, icon)
            desc.text = itemData!!.desc
            icon.setOnClickListener { PicPreviewActivity.startActivity(context, itemData!!.url) }
            icon.setOnLongClickListener {
                if (layout !is GridLayoutManager) {
                    this@FindMainAdapter.recycler.layoutManager = GridLayoutManager(context, 2)
                } else {
                    this@FindMainAdapter.recycler.layoutManager = LinearLayoutManager(context)
                }
                //this@FindMainAdapter.recycler.let {
                //    it.postDelayed({ it.adapter.notifyDataSetChanged() }, 500)
                //}
                return@setOnLongClickListener false
            }
        }
    }
}
