package com.dandan.tzx.main.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dandan.tzx.R
import com.tzx.framework.base.BaseFragment
import com.dandan.tzx.main.activity.MainActivity
import com.dandan.tzx.main.model.GankTodayDataEntities
import com.dandan.tzx.main.model.historyList
import com.dandan.tzx.main.task.HistoryListTask
import com.dandan.tzx.view.adapter.HistoryMainAdapter
import kotlinx.android.synthetic.main.fragment_find_main_layout.*

/**
 * Created by Tanzhenxing
 * Date: 2018/8/23 下午5:14
 * Description:
 */
@SuppressLint("ValidFragment")
class HistoryFragment(activity: MainActivity) : BaseFragment() {
    private var pageName = 5
    private var isRrefreshState = false
    private var pageIndex = 0
    private val adapter: HistoryMainAdapter by lazy { HistoryMainAdapter(activity) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_history_main_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        getListData()
    }

    fun initView() {
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.adapter = this.adapter
        swipe_refresh_layout.isRefreshing = false
        swipe_refresh_layout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light)
        swipe_refresh_layout.setProgressBackgroundColorSchemeResource(android.R.color.white)
        swipe_refresh_layout.setOnRefreshListener {
            if (isRrefreshState) {
                return@setOnRefreshListener
            } else {
                isRrefreshState = true
                pageIndex = 0
                getListData()
            }
        }
        mRecyclerView.setOnScrollListener(object : RecyclerView.OnScrollListener(){
            private var isScolled = false
            private var countItem = 0
            private var lastItem = 0
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                isScolled = (newState == RecyclerView.SCROLL_STATE_DRAGGING
                        || newState == RecyclerView.SCROLL_STATE_SETTLING)
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (recyclerView!!.layoutManager is LinearLayoutManager) {
                    val layoutManager = recyclerView.layoutManager
                    countItem = layoutManager.itemCount
                    lastItem = (layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
                }
                if (isScolled && countItem !== lastItem && lastItem == countItem - 1) {
                    Toast.makeText(activity!!.applicationContext, "下一页", Toast.LENGTH_SHORT).show()
                    getListData()
                }
            }
        })
    }

    private fun getListData() {
        if (historyList == null || historyList!!.error) {
            return
        }
        val path = historyList!!.results[pageIndex].replace("-", "/")
        val s = submitForObservable(HistoryListTask(path))
                .subscribe(object: com.tzx.framework.retrofit.SimpleSubscriber<GankTodayDataEntities>() {
                    override fun onNext(t: GankTodayDataEntities) {
                        super.onNext(t)
                        swipe_refresh_layout.isRefreshing = false
                        if (!t.error) {
                            if (pageIndex == 0) {
                                adapter!!.clean()
                            }
                            pageIndex++
                            if (t.results.meizhi != null && t.results.meizhi.isNotEmpty()) {
                                adapter!!.addItemData(t)
                            }
                            if (pageName == 0) {
                                pageName = 5
                                isRrefreshState = false
                                adapter!!.notifyDataSetChanged()
                            } else {
                                pageName--
                                getListData()
                            }
                        }
                    }
                })
        addSubscription(s)
    }
}