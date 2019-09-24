package com.tzx.githubclient.main.retrofit

import com.tzx.framework.retrofit.JobInterceptor
import com.tzx.framework.retrofit.JobNetworkInterceptor
import com.tzx.framework.retrofit.RetrofitApiFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Created by Tanzhenxing
 * Date: 2019-09-23 14:28
 * Description:
 */
object GithubRetrofitApiFactory : RetrofitApiFactory() {
    override fun initOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(GithubAuthInterceptor())
                .addInterceptor(JobInterceptor())
                .addNetworkInterceptor(JobNetworkInterceptor())
                .cache(cache)
                .build()
        cacheMap.clear()
    }
}