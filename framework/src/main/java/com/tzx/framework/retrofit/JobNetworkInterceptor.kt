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
class JobNetworkInterceptor : Interceptor {
    val TAG = "JobNetworkInterceptor"
    override fun intercept(chain: Interceptor.Chain?): Response {
        var request: Request = chain!!.request()
        var response: Response = chain.proceed(request)
        if (!response.isSuccessful) {
            RetrofitApiFactory.instance.initOkHttpClient()
        } else {
            val maxAge: Int = request.cacheControl().maxAgeSeconds()
            if (request.cacheControl().isPublic && maxAge > 1) {
                Log.d(TAG, "response need cache~!")
                response = response.newBuilder()
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build()
            }
        }
        return response
    }

}