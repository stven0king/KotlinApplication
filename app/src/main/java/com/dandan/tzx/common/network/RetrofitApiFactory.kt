package com.dandan.tzx.common.network

import com.dandan.tzx.common.utils.getappCacheDir
import com.dandan.tzx.config.FileConfig
import com.dandan.tzx.config.GankioConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit

/**
 * Created by Tanzhenxing
 * Date: 2018/8/24 上午9:29
 * Description:
 */

object RetrofitApiFactory {
    const val TIME_OUT: Long = 30
    val cacheFile: File = File(getappCacheDir(), FileConfig.NETWORK_CACHE)
    val cache: Cache = Cache(cacheFile, 1024 * 1024 * 50)
    private val cacheMap = ConcurrentHashMap<Class<*>, Retrofit>()

    fun initOkHttpClient():OkHttpClient {
        cacheMap.clear()
        return OkHttpClient.Builder()
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(JobInterceptor())
                .addNetworkInterceptor(JobNetworkInterceptor())
                .cache(cache)
                .build()
    }

    fun <T> createRetrofit(serviceClass: Class<T>): Retrofit? {
        return if (cacheMap.contains(serviceClass)) {
            cacheMap[serviceClass]
        } else {
            val retrofit = Retrofit.Builder()
                    .baseUrl(GankioConfig.GankBaseUrl)
                    .client(initOkHttpClient())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            cacheMap.put(serviceClass, retrofit)
            retrofit
        }
    }
}