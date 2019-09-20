package com.tzx.framework.retrofit


import com.tzx.framework.utils.getappCacheDir
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

class RetrofitApiFactory private constructor(){
    val cacheFile: File = File(getappCacheDir(), "retrofitCache")
    private var cache: Cache = Cache(cacheFile, 1024 * 1024 * 50)
    private val cacheMap = ConcurrentHashMap<Class<*>, Retrofit>()

    public fun config(cacheFile: File) {
        config(Cache(cacheFile, 1024 * 1024 * 50))
    }

    public fun config(cache:Cache) {
        this.cache = cache
    }

    fun initOkHttpClient():OkHttpClient {
        cacheMap.clear()
        return OkHttpClient.Builder()
                .readTimeout(Companion.TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(Companion.TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(JobInterceptor())
                .addNetworkInterceptor(JobNetworkInterceptor())
                .cache(cache)
                .build()
    }

    fun <T> createRetrofit(serviceClass: Class<T>): Retrofit? {
        return if (cacheMap.contains(serviceClass)) {
            cacheMap[serviceClass]
        } else {
            val host = serviceClass.getAnnotation(Host::class.java)
            requireNotNull(host) { "请在" + serviceClass.simpleName + "接口上添加host配置" }
            val retrofit = Retrofit.Builder()
                    .baseUrl(host.baseUrl)
                    .client(initOkHttpClient())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            cacheMap.put(serviceClass, retrofit)
            retrofit
        }
    }

    companion object {
        const val TIME_OUT: Long = 30
        val instance = SingletonHolder.instance
    }

    private object SingletonHolder {
        val instance = RetrofitApiFactory()
    }
}