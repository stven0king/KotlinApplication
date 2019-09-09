package com.dandan.tzx.common.network

import rx.Observable

/**
 * Created by Tanzhenxing
 * Date: 2018/8/22 下午8:13
 * Description:
 */
abstract class RetrofitTask<T> : ITask {
    protected val TAG: String? = this::class.simpleName

    override fun run() {

    }

    abstract fun exeForObservable(): Observable<T>

    fun <T> createService(serviceClass: Class<T>): T {
        return RetrofitApiFactory.createRetrofit(serviceClass)?.create(serviceClass)!!
    }
}