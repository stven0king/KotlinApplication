package com.dandan.tzx.main.task

import com.dandan.tzx.main.model.GankBannerDataEntities
import com.dandan.tzx.main.model.GankBannerItemBean
import com.dandan.tzx.main.service.GankServiceV2
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Tanzhenxing
 * Date: 2020/11/6 3:14 PM
 * Description:
 */
class GankBannerListTask : com.tzx.framework.retrofit.RetrofitTask<GankBannerDataEntities>() {
    override fun exeForObservable(): Observable<GankBannerDataEntities> {
        return createService(GankServiceV2::class.java)
                .getBanners()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}