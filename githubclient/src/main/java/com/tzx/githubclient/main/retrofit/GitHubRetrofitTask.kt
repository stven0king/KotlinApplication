package com.tzx.githubclient.main.retrofit

import com.tzx.framework.retrofit.RetrofitTask

/**
 * Created by Tanzhenxing
 * Date: 2019-09-24 10:04
 * Description:
 */
abstract class GitHubRetrofitTask<T> : RetrofitTask<T>() {
    override fun <T> createService(serviceClass: Class<T>): T = GithubRetrofitApiFactory.createRetrofit(serviceClass)?.create(serviceClass)!!
}