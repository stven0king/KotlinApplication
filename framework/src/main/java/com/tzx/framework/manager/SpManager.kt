package com.tzx.framework.manager

import com.tzx.framework.base.FConfig
import com.tzx.framework.utils.SpUtils

/**
 * Created by Tanzhenxing
 * Date: 2019-09-23 16:15
 * Description:
 */
object SpManager {
    private val allSpUtils = HashMap<String, SpUtils>()
    fun getSP(spName: String): SpUtils {
        if (allSpUtils.size == 0 || allSpUtils[spName] == null) {
            val temp = SpUtils(FConfig.application!!, spName)
            allSpUtils[spName] = temp
        }
        return allSpUtils[spName]!!
    }
}