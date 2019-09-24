package com.tzx.githubclient.main.retrofit.service

import android.support.annotation.StringDef
import com.tzx.framework.retrofit.Host
import com.tzx.githubclient.config.GithubConfig
import com.tzx.githubclient.main.model.GitHubRepoVo
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable
import java.util.ArrayList

/**
 * Created by Tanzhenxing
 * Date: 2019-09-24 10:33
 * Description:
 */
@Host(GithubConfig.GITHUB_API)
interface GithubRepoService {

    @Headers("Cache-Control: public, max-age=3600")
    @GET("repos/{owner}/{name}")
    fun get(@Path("owner") owner: String,
            @Path("name") repo: String): Observable<JSONObject>

    @Headers("Cache-Control: public, max-age=600")
    @GET("user/repos")
    fun getMyRepos(@Query("sort") @RepoSortStatus sort: String,
                   @Query("type") @RepoType type: String): Observable<List<GitHubRepoVo>>

    @Headers("Cache-Control: public, max-age=600")
    @GET("users/{name}/repos")
    fun getUserRepos(@Path("name") user: String,
                     @Query("sort") @RepoSortStatus sort: String,
                     @Query("type") @RepoType type: String): Observable<List<GitHubRepoVo>>
}

const val ALL = "all"
const val OWNER = "owner"
const val PUBLIC = "public"
const val PRIVATE = "private"
const val MEMBER = "member"

@StringDef(ALL, OWNER, PUBLIC, PRIVATE, MEMBER)
@Retention(AnnotationRetention.SOURCE)
annotation class RepoType


const val CREATED = "created"
const val UPDATED = "updated"
const val PUSHED = "pushed"
const val FULL_NAME = "full_name"
@StringDef(CREATED, UPDATED, PUSHED, FULL_NAME)
@Retention(AnnotationRetention.SOURCE)
annotation class RepoSortStatus