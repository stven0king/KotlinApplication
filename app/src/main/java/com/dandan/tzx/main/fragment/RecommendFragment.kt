package com.dandan.tzx.main.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.dandan.tzx.R
import com.tzx.framework.base.BaseActivity
import com.tzx.framework.base.BaseFragment
import com.dandan.tzx.main.activity.PicPreviewActivity
import com.dandan.tzx.main.model.GankItemEntiry
import com.dandan.tzx.main.model.GankTodayDataEntities
import com.dandan.tzx.main.task.TodayListTask
import com.dandan.tzx.view.adapter.RecommendMainAdapter
import com.tzx.framework.manager.ImageLoader
import kotlinx.android.synthetic.main.fragment_recommend_main_layout.*

/**
 * Created by Tanzhenxing
 * Date: 2018/8/23 下午5:14
 * Description:
 */
@SuppressLint("ValidFragment")
class RecommendFragment(activity: BaseActivity) : BaseFragment() {
    companion object {
        val DATA = "data"
    }
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

    private fun initData() {
        if (arguments != null) {
            val t = arguments!!.getParcelable<GankTodayDataEntities>(DATA)
            if (t != null) {
                setViewData(t)
            }
            return
        }
        val s = submitForObservable(TodayListTask())
                .subscribe(object: com.tzx.framework.retrofit.SimpleSubscriber<GankTodayDataEntities>() {
                    override fun onNext(t: GankTodayDataEntities) {
                        super.onNext(t)
                        setViewData(t)
                    }
                })
        addSubscription(s)
    }


    private fun setViewData(t:GankTodayDataEntities) {
        if (!t.error) {
            updateViewPage(t.results.meizhi)
            var list = mutableListOf<Any>()
            t.results.android?.let {
                list.add("Android")
                list.addAll(it)
            }
            t.results.ios?.let {
                list.add("IOS")
                list.addAll(it)
            }
            t.results.fe?.let {
                list.add("前端")
                list.addAll(it)
            }
            t.results.app?.let {
                list.add("App")
                list.addAll(it)
            }
            t.results.source?.let {
                list.add("扩展资源")
                list.addAll(it)
            }
            t.results.recommend?.let {
                list.add("瞎推荐")
                list.addAll(it)
            }
            t.results.video?.let {
                list.add("休息视频")
                list.addAll(it)
            }
            adapter.clean()
            adapter.addData(list)
            adapter.notifyDataSetChanged()
        }
    }

    fun updateViewPage(list: List<GankItemEntiry>?) {
        if (list == null) return
        val listView = mutableListOf<View>()
        for (item in list) {
            val image = ImageView(activity)
            image.scaleType = ImageView.ScaleType.CENTER_CROP
            ImageLoader.load(item.url, image)
            image.setOnClickListener { PicPreviewActivity.startActivity(activity!!, item.url) }
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