package com.dandan.tzx.main.task

import com.dandan.tzx.main.model.CategoryDataEntities
import com.dandan.tzx.main.service.GankServiceV2
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Tanzhenxing
 * Date: 2019-08-30 17:01
 * Description: 获取分类数据
 */
class CategoryListTask(val type: String, val pageSize: Int, val pageName: Int)
        : com.tzx.framework.retrofit.RetrofitTask<CategoryDataEntities>() {
    override fun exeForObservable(): Observable<CategoryDataEntities> {
        return createService(GankServiceV2::class.java)
                .getCategoryData(type, pageName, pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}