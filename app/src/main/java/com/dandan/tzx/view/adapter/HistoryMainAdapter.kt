package com.dandan.tzx.view.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dandan.tzx.common.view.BaseAdapter
import com.dandan.tzx.common.view.BaseViewHolder
import com.dandan.tzx.config.GlideApp
import com.dandan.tzx.main.model.GankTodayDataEntities
import com.dandan.tzx.R
import com.dandan.tzx.main.activity.OneDayActivity


/**
 * Created by Tanzhenxing
 * Date: 2019-09-02 15:41
 * Description:
 */
class HistoryMainAdapter(context: Context) : BaseAdapter<GankTodayDataEntities>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<GankTodayDataEntities> {GankTodayDataEntities
        val view = mInflater.inflate(R.layout.item_history_layout, parent, false)
        return ViewHolder(view)
    }


    inner class ViewHolder(view: View) : BaseViewHolder<GankTodayDataEntities>(view) {
        val icon: ImageView = itemView!!.findViewById(R.id.icon)
        val desc: TextView = itemView!!.findViewById(R.id.desc)
        val time: TextView = itemView!!.findViewById(R.id.time)
        val layout:View = itemView!!.findViewById(R.id.content_view)
        override fun onBind(i: GankTodayDataEntities, p: Int) {
            super.onBind(i, p)
            GlideApp.with(itemView).load(itemData!!.results!!.meizhi?.get(0)!!.url).into(icon)
            desc.text = getTitle(itemData)
            time.text = itemData!!.results.meizhi?.get(0)!!.desc
            layout.setOnClickListener {
                val intent = Intent(context, OneDayActivity::class.java)
                intent.putExtra(OneDayActivity.DATA, itemData)
                context.startActivity(intent)
            }
        }
    }

    fun getTitle(itemBean: GankTodayDataEntities?): String {
        var result = ""
        if (itemBean != null && itemBean!!.results != null) {
            if (itemBean!!.results.android != null && itemBean!!.results.android!!.size > 0) {
                result = itemBean!!.results.android?.get(0)!!.desc
            }
        }
        return result
    }
}
