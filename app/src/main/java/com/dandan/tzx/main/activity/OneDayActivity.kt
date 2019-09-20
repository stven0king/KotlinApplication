package com.dandan.tzx.main.activity

import android.os.Bundle
import com.dandan.tzx.R
import com.dandan.tzx.common.activity.BaseActivity
import com.dandan.tzx.main.fragment.RecommendFragment
import com.dandan.tzx.main.model.GankTodayDataEntities
import kotlinx.android.synthetic.main.activity_main_layout.*

/**
 * Created by Tanzhenxing
 * Date: 2019-09-16 10:54
 * Description:
 */
class OneDayActivity : BaseActivity() {
    companion object {
        val DATA = "DATA"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_day_layout)
        setSupportActionBar(toolBar)
        if (intent != null) {
            val d = intent.getParcelableExtra<GankTodayDataEntities>(DATA)
            if (d == null) {
                return
                finish()
            }
            val ben = supportFragmentManager.beginTransaction()
            val fragment = RecommendFragment(this)
            val args = Bundle()
            args.putParcelable(RecommendFragment.DATA, d)
            fragment.arguments = args
            ben.add(R.id.container_layout, fragment)
            ben.commitAllowingStateLoss()
        }
    }
}