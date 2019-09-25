package com.dandan.tzx.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.dandan.tzx.R
import com.tzx.framework.view.BaseAdapter
import com.tzx.framework.view.BaseViewHolder
import com.tzx.framework.common.WebActivity
import com.dandan.tzx.main.model.GankItemEntiry
import com.tzx.framework.manager.ImageLoader
import com.tzx.githubclient.main.activity.GithubRepoListActivity
import com.tzx.githubclient.main.activity.GithubUserInfoActivity

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
                ImageLoader.load(data.images[0], icon_iv)
                var l = content_tv.layoutParams as RelativeLayout.LayoutParams
                l.rightMargin = com.tzx.framework.utils.dip2px( 90f)
                content_tv.layoutParams = l
            } else {
                icon_iv.visibility = View.GONE
                var l = content_tv.layoutParams as RelativeLayout.LayoutParams
                l.rightMargin = 0
                content_tv.layoutParams = l

            }
            content_tv.text = data.desc
            author_tv.text = data.who
            itemView!!.setOnClickListener {
                if (data.url.contains("github.com")) {
                    val name = data.url.substring(data.url.indexOf("com") + 4, data.url.indexOf("/", data.url.indexOf("com") + 4))
//                    GithubRepoListActivity.startActivity(context, name)
                    GithubUserInfoActivity.startActivity(context, name)
                } else {
                    WebActivity.startActivity(context, data.type, data.url)
                }
            }
        }
    }
}
