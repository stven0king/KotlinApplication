package com.dandan.tzx.main.task

import com.dandan.tzx.common.network.RetrofitTask
import com.dandan.tzx.main.model.CategoryDataEntities
import com.dandan.tzx.main.model.GankTodayDataEntities
import com.dandan.tzx.main.service.GankService
import org.json.JSONObject
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Tanzhenxing
 * Date: 2019-08-30 17:01
 * Description:
 */
class CategoryListTask(val type: String, val pageSize: Int, val pageName: Int)
        : RetrofitTask<CategoryDataEntities>() {
    override fun exeForObservable(): Observable<CategoryDataEntities> {
        return createService(GankService::class.java)
                .getCategoryData(type, "$pageSize/$pageName")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}