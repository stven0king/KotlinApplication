package com.dandan.tzx.main.service

import com.dandan.tzx.main.model.CategoryDataEntities
import com.dandan.tzx.main.model.GankTodayDataEntities
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url
import rx.Observable

/**
 * Created by Tanzhenxing
 * Date: 2019-08-30 16:03
 * Description:
 */

interface GankService {
    @GET("/api/today")
    fun getTodayData(): Observable<GankTodayDataEntities>

    @GET("api/data/{type}/{path}")
    fun getCategoryData(@Path("type") type:String,
                        @Path("path") path: String): Observable<CategoryDataEntities>
}