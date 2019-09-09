package com.dandan.tzx.main.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.dandan.tzx.R
import com.dandan.tzx.common.activity.BaseFragment
import com.dandan.tzx.common.network.SimpleSubscriber
import com.dandan.tzx.config.GlideApp
import com.dandan.tzx.main.activity.MainActivity
import com.dandan.tzx.main.model.GankItemEntiry
import com.dandan.tzx.main.model.GankTodayDataEntities
import com.dandan.tzx.main.task.TodayListTask
import com.dandan.tzx.view.adapter.RecommendMainAdapter
import kotlinx.android.synthetic.main.fragment_recommend_main_layout.*

/**
 * Created by Tanzhenxing
 * Date: 2018/8/23 下午5:14
 * Description:
 */
@SuppressLint("ValidFragment")
class RecommendFragment(activity: MainActivity) : BaseFragment() {
    private val viewPageAdapter: ViewPageAdapter by lazy { ViewPageAdapter() }
    private val adapter:RecommendMainAdapter by lazy { RecommendMainAdapter(activity) }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recommend_main_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    fun initView() {
        view_pager.adapter = viewPageAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.adapter = this.adapter
    }

    fun initData() {
        val s = submitForObservable(TodayListTask())
                .subscribe(object: SimpleSubscriber<GankTodayDataEntities>() {
                    override fun onNext(t: GankTodayDataEntities) {
                        super.onNext(t)
                        if (!t.error) {
                            updateViewPage(t.results.meizhi)
                            var list = mutableListOf<Any>()
                            list.add("Android")
                            list.addAll(t.results.android)
                            list.add("IOS")
                            list.addAll(t.results.ios)
                            list.add("休息视频")
                            list.addAll(t.results.video)
                            adapter.clean()
                            adapter.addData(list)
                            adapter.notifyDataSetChanged()
                        }
                    }
                })
        addSubscription(s)
    }

    fun updateViewPage(list: List<GankItemEntiry>) {
        val listView = mutableListOf<View>()
        for (item in list) {
            val image = ImageView(activity)
            image.scaleType = ImageView.ScaleType.CENTER_CROP
            GlideApp.with(activity).load(item.url).into(image)
            listView.add(image)
        }
        viewPageAdapter.list = listView
        viewPageAdapter.notifyDataSetChanged()
    }

    inner class ViewPageAdapter: PagerAdapter() {
        var list: List<View>? = null
        override fun getCount(): Int {
            return list?.size ?: 0
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(list!![position])
        }

        override fun isViewFromObject(view: View, a: Any): Boolean {
            return view == a
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            container.addView(list!![position], 0, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
            return list!![position]
        }
    }
}