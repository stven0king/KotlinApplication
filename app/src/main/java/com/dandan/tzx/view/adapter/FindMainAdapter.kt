package com.dandan.tzx.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dandan.tzx.R
import com.tzx.framework.view.BaseAdapter
import com.tzx.framework.view.BaseViewHolder
import com.dandan.tzx.config.GlideApp
import com.dandan.tzx.main.activity.PicPreviewActivity
import com.dandan.tzx.main.model.GankItemEntiry

/**
 * Created by Tanzhenxing
 * Date: 2019-09-02 15:41
 * Description:
 */
class FindMainAdapter(context: Context) : BaseAdapter<GankItemEntiry>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<GankItemEntiry> {
        val view = mInflater.inflate(R.layout.item_find_layout, parent, false)
        return ViewHolder(view)
    }


    inner class ViewHolder(view: View) : BaseViewHolder<GankItemEntiry>(view) {
        val icon: ImageView = itemView!!.findViewById(R.id.icon)
        val desc: TextView = itemView!!.findViewById(R.id.desc)
        override fun onBind(i: GankItemEntiry, p: Int) {
            super.onBind(i, p)
            GlideApp.with(itemView).load(itemData!!.url).into(icon)
            desc.text = itemData!!.desc
            icon.setOnClickListener { PicPreviewActivity.startActivity(context, itemData!!.url) }
        }
    }
}
