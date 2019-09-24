package com.tzx.githubclient.main.model

/**
 * Created by Tanzhenxing
 * Date: 2019-09-23 10:53
 * Description:
 */
data class GithubAuthVo(var scopes: Array<String>,
                        var note:String?,
                        var note_url:String?,
                        var client_id:String,
                        var client_secret:String?,
                        var fingerprint:String?)