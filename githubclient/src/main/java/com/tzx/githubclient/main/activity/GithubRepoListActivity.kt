package com.tzx.githubclient.main.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.tzx.framework.base.BaseActivity
import com.tzx.framework.retrofit.SimpleSubscriber
import com.tzx.githubclient.R
import com.tzx.githubclient.main.adapter.GithubRepoListAdapter
import com.tzx.githubclient.main.model.GitHubRepoVo
import com.tzx.githubclient.main.retrofit.service.ALL
import com.tzx.githubclient.main.retrofit.task.GithubUserRepoList
import kotlinx.android.synthetic.main.github_repo_list_activity.*

/**
 * Created by Tanzhenxing
 * Date: 2019-09-24 14:44
 * Description:
 */
class GithubRepoListActivity : BaseActivity() {
    companion object{
        private const val OWNER_NAME = "login_repo"
        fun startActivity(context: Context, name: String) {
            val i = Intent(context, GithubRepoListActivity::class.java)
            i.putExtra(OWNER_NAME, name)
            context.startActivity(i)
        }
    }
    private var loginName: String? = null
    private val adapter by lazy { GithubRepoListAdapter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.github_repo_list_activity)
        setSupportActionBar(toolBar)
        loginName = intent.getStringExtra(OWNER_NAME)
        supportActionBar?.title = if (loginName.isNullOrBlank()) "GitHub" else loginName
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = this.adapter
        getMyRepos()
    }

    fun getMyRepos() {
        val s = submitForObservable(GithubUserRepoList(loginName!!, ALL, com.tzx.githubclient.main.retrofit.service.OWNER))
                .subscribe(object : SimpleSubscriber<List<GitHubRepoVo>>(){
                    override fun onNext(t: List<GitHubRepoVo>) {
                        super.onNext(t)
                        this@GithubRepoListActivity.adapter.addData(t)
                        this@GithubRepoListActivity.adapter.notifyDataSetChanged()
                    }
                })
        addSubscription(s)

    }
}