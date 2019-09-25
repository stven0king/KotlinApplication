package com.tzx.githubclient.main.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.tzx.framework.base.BaseActivity
import com.tzx.framework.manager.ImageLoader
import com.tzx.framework.retrofit.SimpleSubscriber
import com.tzx.githubclient.R
import com.tzx.githubclient.main.model.GitHubCache
import com.tzx.githubclient.main.model.GithubUser
import com.tzx.githubclient.main.retrofit.task.GithubUserInfoTask
import kotlinx.android.synthetic.main.github_user_info_layout.*

/**
 * Created by Tanzhenxing
 * Date: 2019-09-25 14:13
 * Description:
 */
class GithubUserInfoActivity : BaseActivity() {

    companion object {
        private const val NAME = "name"
        fun startActivity(context: Context, name: String) {
            val intent = Intent(context, GithubUserInfoActivity::class.java)
            intent.putExtra(NAME, name)
            context.startActivity(intent)
        }
    }
    private val name by lazy { intent.getStringExtra(NAME) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.github_user_info_layout)
        if (intent == null || !intent.hasExtra(NAME)) {
            finish()
        }
        setSupportActionBar(toolBar)
        initData()
    }

    private fun updateView(user: GithubUser) {
        supportActionBar!!.title = user.login
        ImageLoader.load(user.avatar_url, avatar_iv)
        name_tv.text = user.name
        login_tv.text = user.login
        location_tv.text = user.location
        blog_tv.text = user.blog
        biography_tv.text = user.bio
        email_tv.text = user.email
        company_tv.text = user.company
        repo_tv.text = "Repositories:" + user.public_repos
        repo_layout.setOnClickListener {
            GithubRepoListActivity.startActivity(this@GithubUserInfoActivity, user.login)
        }
    }

    private fun initData() {
        val s = submitForObservable(GithubUserInfoTask(name))
                .subscribe(object: SimpleSubscriber<GithubUser>(){
                    override fun onNext(t: GithubUser) {
                        super.onNext(t)
                        updateView(t)
                    }
                })
        addSubscription(s)
    }
}
