package com.tzx.githubclient.main.retrofit.task

import com.tzx.githubclient.main.model.GithubUser
import com.tzx.githubclient.main.retrofit.GitHubRetrofitTask
import com.tzx.githubclient.main.retrofit.service.GithubRepoService
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Tanzhenxing
 * Date: 2019-09-23 11:26
 * Description:
 */
class GithubUserInfoTask(private val username:CharSequence) : GitHubRetrofitTask<GithubUser>() {

    override fun exeForObservable(): Observable<GithubUser> {
        return createService(GithubRepoService::class.java)
                .getUserInfo(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}