package com.dandan.tzx.main.service

import com.dandan.tzx.config.GankioConfig
import com.dandan.tzx.main.model.CategoryDataEntities
import com.dandan.tzx.main.model.GankHistoryDay
import com.dandan.tzx.main.model.GankTodayDataEntities
import com.tzx.framework.retrofit.Host
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by Tanzhenxing
 * Date: 2019-08-30 16:03
 * Description:
 */

@Host(GankioConfig.GankBaseUrl)
interface GankService {

    @GET("api/day/history")
    fun getHistoryDayList(): Observable<GankHistoryDay>

    @GET("api/today")
    fun getTodayData(): Observable<GankTodayDataEntities>

    @GET("api/day/{path}")
    fun getHistoryData(@Path("path") path: String): Observable<GankTodayDataEntities>


}