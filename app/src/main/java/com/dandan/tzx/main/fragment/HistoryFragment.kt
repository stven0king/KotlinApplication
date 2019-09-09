package com.dandan.tzx.main.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dandan.tzx.App
import com.dandan.tzx.R
import com.dandan.tzx.common.activity.BaseFragment
import com.dandan.tzx.common.utils.getDisplayWidth
import com.dandan.tzx.main.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_find_main_layout.*

/**
 * Created by Tanzhenxing
 * Date: 2018/8/23 下午5:14
 * Description:
 */
@SuppressLint("ValidFragment")
class HistoryFragment(activity: MainActivity) : BaseFragment() {
    private lateinit var activity: MainActivity
    private val mDisplayWidth = getDisplayWidth(App.application!!)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tanzhenxing", "HistoryFragment")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_find_main_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("tanzhenxing", "HistoryFragment:onViewCreated")
        initView()
    }

    fun initView() {
        val width = (mDisplayWidth - 100) / 2
        val height = (width * 0.618) / 0.382
        content_view.setBackgroundColor(Color.BLACK)
    }
}