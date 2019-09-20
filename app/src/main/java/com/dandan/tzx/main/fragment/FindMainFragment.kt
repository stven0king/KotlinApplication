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
import com.dandan.tzx.config.GankioConfig
import com.dandan.tzx.main.activity.MainActivity
import com.dandan.tzx.main.model.CategoryDataEntities
import com.dandan.tzx.main.task.CategoryListTask
import com.dandan.tzx.view.adapter.FindMainAdapter
import kotlinx.android.synthetic.main.fragment_find_main_layout.*


/**
 * Created by Tanzhenxing
 * Date: 2018/8/23 下午5:14
 * Description:
 */
@SuppressLint("ValidFragment")
class FindMainFragment(activity: MainActivity) : BaseFragment() {
    private val pageSize = 10
    private var pageName = 1
    private val adapter: FindMainAdapter by lazy { FindMainAdapter(activity) }
    private var isRrefreshState = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_find_main_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        getListData()
    }

    private fun initView() {
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
                pageName = 1
                getListData()
            }
        }
        mRecyclerView.setOnScrollListener(object :RecyclerView.OnScrollListener(){
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
        val s = submitForObservable(CategoryListTask(GankioConfig.GankCategoryType[6], pageSize, pageName))
                .subscribe(object: com.tzx.framework.retrofit.SimpleSubscriber<CategoryDataEntities>() {
                    override fun onNext(t: CategoryDataEntities) {
                        super.onNext(t)
                        swipe_refresh_layout.isRefreshing = false
                        if (!t.error) {
                            isRrefreshState = false
                            if (pageName == 1) {
                                adapter!!.clean()
                            }
                            pageName++
                            adapter!!.addData(t.results)
                            adapter!!.notifyDataSetChanged()
                        }
                    }
                })
        addSubscription(s)
    }
}