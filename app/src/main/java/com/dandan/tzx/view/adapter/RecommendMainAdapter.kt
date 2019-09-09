package com.dandan.tzx.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.dandan.tzx.App
import com.dandan.tzx.R
import com.dandan.tzx.common.utils.dip2px
import com.dandan.tzx.common.view.BaseAdapter
import com.dandan.tzx.common.view.BaseViewHolder
import com.dandan.tzx.config.GlideApp
import com.dandan.tzx.main.model.GankItemEntiry

/**
 * Created by Tanzhenxing
 * Date: 2019-09-02 15:41
 * Description:
 */
class RecommendMainAdapter(context: Context) : BaseAdapter<Any>(context) {
    private val TITLE_TYPE = 0
    private val NORMAL_TYPE = 2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> =
        when(viewType) {
            TITLE_TYPE -> {
                val view = mInflater.inflate(R.layout.item_recommend_title_main, parent, false)
                TitleViewHolder(view)
            }
            else -> {
                val view = mInflater.inflate(R.layout.item_recommend_main, parent, false)
                ViewHolder(view)
            }
        }

    override fun getItemViewType(position: Int): Int {
        val d = this.mData?.get(position)
        if (d is String) {
            return TITLE_TYPE
        }
        return NORMAL_TYPE
    }

    inner class TitleViewHolder(view: View) : BaseViewHolder<Any>(view) {
        val title_tv: TextView = itemView!!.findViewById(R.id.title_tv)
        override fun onBind(i: Any, p: Int) {
            super.onBind(i, p)
            val s = itemData as String
            title_tv.text = s
        }
    }


    inner class ViewHolder(view: View) : BaseViewHolder<Any>(view) {
        val icon_iv: ImageView = itemView!!.findViewById(R.id.icon_iv)
        val content_tv: TextView = itemView!!.findViewById(R.id.content_tv)
        val author_tv: TextView = itemView!!.findViewById(R.id.author_tv)
        override fun onBind(i: Any, p: Int) {
            super.onBind(i, p)
            val data = itemData as GankItemEntiry
            if (data.images != null && data.images.isNotEmpty()) {
                icon_iv.visibility = View.VISIBLE
                GlideApp.with(itemView).load(data.images[0]).into(icon_iv)
                var l = content_tv.layoutParams as RelativeLayout.LayoutParams
                l.rightMargin = dip2px(App.application!!, 90f)
                content_tv.layoutParams = l
            } else {
                icon_iv.visibility = View.GONE
                var l = content_tv.layoutParams as RelativeLayout.LayoutParams
                l.rightMargin = 0
                content_tv.layoutParams = l

            }
            content_tv.text = data.desc
            author_tv.text = data.who
        }
    }
}
