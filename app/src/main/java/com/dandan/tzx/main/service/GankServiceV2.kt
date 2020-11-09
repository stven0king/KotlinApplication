package com.dandan.tzx.main.service

import com.dandan.tzx.config.GankioConfig
import com.dandan.tzx.main.model.CategoryDataEntities
import com.dandan.tzx.main.model.GankBannerDataEntities
import com.dandan.tzx.main.model.GankBannerItemBean
import com.tzx.framework.retrofit.Host
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by Tanzhenxing
 * Date: 2020/11/6 3:09 PM
 * Description:
 */
@Host(GankioConfig.GankBaseUrlV2)
interface GankServiceV2 {
    @GET("banners")
    fun getBanners(): Observable<GankBannerDataEntities>

    @GET("data/category/{type}/type/{type}/page/{page}/count/{count}")
    fun getCategoryData(@Path("type") type:String,
                        @Path("page") page: Int,
                        @Path("count") count: Int): Observable<CategoryDataEntities>

    //帖子详情
    //https://gank.io/api/v2/post/5e777432b8ea09cade05263f

    //本周最热
    //views:浏览数，likes:点赞数，comments:评论数
    //Article|GanHuo|Gril
    //count[1,20]
    //https://gank.io/api/v2/hot/views/category/Girl/count/100


    //文章评论获取
    //https://gank.io/api/v2/post/comments/<post_id>
}