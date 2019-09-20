package com.tzx.framework.retrofit

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by Tanzhenxing
 * Date: 2018/8/24 上午10:11
 * Description:
 */
class JobInterceptor : Interceptor {
    val TAG = "JobInterceptor"
    override fun intercept(chain: Interceptor.Chain?): Response {
        /*-------------请求的时候添加header---------------*/
        var request: Request = chain!!.request()
        /*-------------请求的时候输出log---------------*/
        val requestUrl: String = request.url().url().toString()
        Log.d(TAG, "[intercept] request :" + requestUrl)
        val startTime = System.currentTimeMillis()
        /*------------请求如果失败初始化 okhttpclient---*/
        var response: Response = chain.proceed(request)
        if (!response.isSuccessful) {
            RetrofitApiFactory.instance.initOkHttpClient()
        } else {
            val maxAge: Int = request.cacheControl().maxAgeSeconds()
            if (request.cacheControl().isPublic && maxAge > 1) {
                response = response.newBuilder()
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build()
            }
        }
        return response
    }

}