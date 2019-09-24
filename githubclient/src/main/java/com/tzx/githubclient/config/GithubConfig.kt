package com.tzx.githubclient.config

/**
 * Created by Tanzhenxing
 * Date: 2019-09-23 10:22
 * Description:
 */
object GithubConfig {
    const val CLIENT_ID = "5b074b14a3c166278774"
    const val CLIENT_SECRET = "a2c539a256cd861cd9dcc5c86e51a53baf4c96a5"
    const val NOTE = "GithubApp"
    val SCOPES = arrayOf("user", "repo", "notifications", "gist", "admin:org")

    const val GITHUB_API = "https://api.github.com/"
}