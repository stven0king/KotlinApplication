package com.dandan.tzx.main.task

import com.tzx.framework.retrofit.RetrofitTask
import com.dandan.tzx.main.model.GankTodayDataEntities
import com.dandan.tzx.main.service.GankService
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Tanzhenxing
 * Date: 2019-08-30 17:01
 * Description:
 */
class TodayListTask : com.tzx.framework.retrofit.RetrofitTask<GankTodayDataEntities>() {
    override fun exeForObservable(): Observable<GankTodayDataEntities> {
        return createService(GankService::class.java)
                .getTodayData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}