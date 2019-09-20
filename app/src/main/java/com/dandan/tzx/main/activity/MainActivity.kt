package com.dandan.tzx.main.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import com.dandan.tzx.R
import com.tzx.framework.base.BaseActivity
import com.dandan.tzx.main.fragment.FindMainFragment
import com.dandan.tzx.main.fragment.HistoryFragment
import com.dandan.tzx.main.fragment.RecommendFragment
import com.dandan.tzx.main.model.GankHistoryDay
import com.dandan.tzx.main.task.GankHistoryListTask
import com.dandan.tzx.view.adapter.BottomAdapter
import kotlinx.android.synthetic.main.activity_main_layout.*
import com.dandan.tzx.main.model.historyList


class MainActivity : BaseActivity() {
    public var list: GankHistoryDay? = null
    private val id_tabs = listOf(R.id.tab_find, R.id.tab_recommend, R.id.tab_history)
    private var currentViewId = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout)
        init()
        getData()
    }

    private fun init() {
        setSupportActionBar(toolBar)
        navigationView.setOnNavigationItemSelectedListener{item ->
            when (item.itemId) {
                id_tabs[0] -> {
                    Log.d("tanzhenxing", "0")
                    viewpage.currentItem = 0
                    currentViewId = 0
                    item.isChecked = true
                }
                id_tabs[1] -> {
                    Log.d("tanzhenxing", "1")
                    viewpage.currentItem = 1
                    item.isChecked = true
                    currentViewId = 1
                }
                id_tabs[2] -> {
                    Log.d("tanzhenxing", "2")
                    viewpage.currentItem = 2
                    item.isChecked = true
                    currentViewId = 2
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
        initViewAdapter(viewpage)
        viewpage.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageSelected(position: Int) {
                val currentItem = viewpage.currentItem
                navigationView.menu.getItem(currentItem).isChecked = true
            }

        })
    }

    private fun initViewAdapter(viewPage: ViewPager) {
        val adapter = BottomAdapter(supportFragmentManager)
        adapter.addFragment(FindMainFragment(this))
        adapter.addFragment(RecommendFragment(this))
        adapter.addFragment(HistoryFragment(this))
        viewPage.adapter = adapter
    }

    private fun getData() {
        val s = submitForObservable(GankHistoryListTask())
                .subscribe(object: com.tzx.framework.retrofit.SimpleSubscriber<GankHistoryDay>() {
                    override fun onNext(t: GankHistoryDay) {
                        super.onNext(t)
                        if (!t.error) {
                            historyList = t
                        }
                    }
                })
        addSubscription(s)
    }
}
