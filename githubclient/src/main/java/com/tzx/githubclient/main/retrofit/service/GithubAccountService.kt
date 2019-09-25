package com.tzx.githubclient.main.retrofit.service

import com.tzx.framework.retrofit.Host
import com.tzx.githubclient.config.GithubConfig
import com.tzx.githubclient.main.model.AuthorizationRespVo
import com.tzx.githubclient.main.model.GithubAuthVo
import com.tzx.githubclient.main.model.GithubUser
import com.tzx.githubclient.main.retrofit.GithubAuthInterceptor
import retrofit2.http.*
import rx.Observable

/**
 * Created by Tanzhenxing
 * Date: 2019-09-23 10:51
 * Description:
 */
@Host(GithubConfig.GITHUB_API)
interface GithubAccountService {

    @POST("/authorizations")
    fun createAuthorization(@Body createAuthorization: GithubAuthVo,
                            @Query(GithubAuthInterceptor.Authorization) auth:String): Observable<AuthorizationRespVo>

    @GET("/user")
    fun getUserInfo(@Query("access_token") accessToken:String): Observable<GithubUser>


}