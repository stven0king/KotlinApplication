package com.dandan.tzx.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Tanzhenxing
 * Date: 2019-09-02 14:25
 * Description:
 */
class BottomAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    private val fragments: ArrayList<Fragment> = ArrayList()
    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
    }

}