package com.tzx.githubclient.main.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.tzx.framework.base.BaseActivity
import com.tzx.framework.retrofit.SimpleSubscriber
import com.tzx.framework.utils.toast
import com.tzx.githubclient.R
import com.tzx.githubclient.main.model.GitHubCache
import com.tzx.githubclient.main.model.GithubUser
import com.tzx.githubclient.main.retrofit.task.GithubAccessTokenTask
import kotlinx.android.synthetic.main.github_login_layout.*

/**
 * Created by Tanzhenxing
 * Date: 2019-09-23 17:39
 * Description:
 */
class GithubLoginActivity : BaseActivity() {
    companion object{
        fun startActivity(context: Context) {
            if (GitHubCache.user == null) {
                context.startActivity(Intent(context, GithubLoginActivity::class.java))
            } else {
                GithubRepoListActivity.startActivity(context, GitHubCache.user!!.login)
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.github_login_layout)
        username_tv.setText("stven0king")
        password_tv.setText("6439810tzx")
        login_btn.setOnClickListener { loginGithub() }
    }

    private fun loginGithub() {
        val s = submitForObservable(GithubAccessTokenTask(username_tv.text.trim(), password_tv.text.trim()))
        .subscribe(object: SimpleSubscriber<GithubUser>(){
            override fun onNext(t: GithubUser) {
                super.onNext(t)
                toast("登录成功")
                GitHubCache.user = t
                GithubRepoListActivity.startActivity(this@GithubLoginActivity, GitHubCache.user!!.login)
                this@GithubLoginActivity.finish()
            }

            override fun onError(e: Throwable?) {
                super.onError(e)
                toast("登录失败")
            }
        })
    }
}