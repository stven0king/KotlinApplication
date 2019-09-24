package com.tzx.githubclient.main.retrofit.task

import com.tzx.githubclient.main.model.GitHubRepoVo
import com.tzx.githubclient.main.retrofit.GitHubRetrofitTask
import com.tzx.githubclient.main.retrofit.service.GithubRepoService
import com.tzx.githubclient.main.retrofit.service.RepoSortStatus
import com.tzx.githubclient.main.retrofit.service.RepoType
import org.json.JSONObject
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Tanzhenxing
 * Date: 2019-09-24 11:35
 * Description:
 */
class GithubUserRepoList(val username: String, @RepoSortStatus val sort: String, @RepoType val type: String)
    : GitHubRetrofitTask<List<GitHubRepoVo>>() {
    override fun exeForObservable(): Observable<List<GitHubRepoVo>> {
        return createService(GithubRepoService::class.java)
                .getUserRepos(username, sort, type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}