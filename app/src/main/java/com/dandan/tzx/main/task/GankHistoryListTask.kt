package com.dandan.tzx.main.task

import com.tzx.framework.retrofit.RetrofitTask
import com.dandan.tzx.main.model.GankHistoryDay
import com.dandan.tzx.main.service.GankService
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Tanzhenxing
 * Date: 2019-09-09 16:47
 * Description:
 */
class GankHistoryListTask : com.tzx.framework.retrofit.RetrofitTask<GankHistoryDay>(){
    override fun exeForObservable(): Observable<GankHistoryDay> {
        return createService(GankService::class.java)
                .getHistoryDayList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}