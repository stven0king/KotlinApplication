package com.tzx.githubclient.main.retrofit

import android.text.TextUtils
import android.util.Base64
import com.tzx.githubclient.config.GithubConfig
import com.tzx.githubclient.main.model.GitHubCache
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Tanzhenxing
 * Date: 2019-09-23 11:05
 * Description:
 */
class GithubAuthInterceptor : Interceptor {
    companion object{
        const val Authorization = "Authorization"
        fun getBasicAuth(username:CharSequence, password:CharSequence):String{
            val userCredentials = "$username:$password"
            return "Basic " + String(Base64.encode(userCredentials.toByteArray(), Base64.DEFAULT));
        }
    }
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (request.url().toString().startsWith(GithubConfig.GITHUB_API)) {
            val requestBuilder = request.newBuilder()
                    .header("Accept", "application/vnd.github.v3.json")
                    .header("User-Agent", "GithubApp")
            val auth = request.url().queryParameter(Authorization)
            if (!auth.isNullOrBlank()) {
                val sourceUrl = request.url().url().toString()
                val url = sourceUrl.substring(0, sourceUrl.indexOf("?"))
                requestBuilder.url(url).header(Authorization, auth?.trim())
            } else if (GitHubCache.user != null && !GitHubCache.github_token.isNullOrBlank()) {
                requestBuilder.header(GithubAuthInterceptor.Authorization, "token " + GitHubCache.github_token)
            }
            return chain.proceed(requestBuilder.build())
        }
        return chain.proceed(request)
    }

}