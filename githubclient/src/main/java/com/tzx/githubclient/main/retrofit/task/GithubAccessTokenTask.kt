package com.tzx.githubclient.main.retrofit.task

import com.tzx.framework.manager.SpManager
import com.tzx.githubclient.config.GitHubSPConfig
import com.tzx.githubclient.config.GithubConfig
import com.tzx.githubclient.main.model.GitHubCache
import com.tzx.githubclient.main.model.GithubAuthVo
import com.tzx.githubclient.main.model.GithubUser
import com.tzx.githubclient.main.retrofit.GitHubRetrofitTask
import com.tzx.githubclient.main.retrofit.GithubAuthInterceptor
import com.tzx.githubclient.main.retrofit.service.GithubAccountService
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Tanzhenxing
 * Date: 2019-09-23 11:26
 * Description:
 */
class GithubAccessTokenTask(private val username:CharSequence, private val password:CharSequence) : GitHubRetrofitTask<GithubUser>() {

    override fun exeForObservable(): Observable<GithubUser> {
        val accountVo = GithubAuthVo(note = GithubConfig.NOTE,
                client_id = GithubConfig.CLIENT_ID,
                client_secret = GithubConfig.CLIENT_SECRET,
                scopes = GithubConfig.SCOPES,
                fingerprint = "",
                note_url = "")
        val service = createService(GithubAccountService::class.java)
        return service
                .createAuthorization(accountVo, GithubAuthInterceptor.getBasicAuth(username, password))
                .subscribeOn(Schedulers.io())
                .flatMap {
                    val token = it?.token ?: ""
                    GitHubCache.github_token = token
                    SpManager.getSP(GitHubSPConfig.SP_NAME).setString(GitHubSPConfig.KEY_LOGIN_TOKEN, token)
                    service.getUserInfo(token)
                }
                .observeOn(AndroidSchedulers.mainThread())
    }

}