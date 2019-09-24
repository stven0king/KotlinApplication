package com.tzx.githubclient.main.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tzx.framework.common.WebActivity
import com.tzx.framework.view.BaseAdapter
import com.tzx.framework.view.BaseViewHolder
import com.tzx.githubclient.R
import com.tzx.githubclient.main.model.GitHubRepoVo


/**
 * Created by Tanzhenxing
 * Date: 2019-09-02 15:41
 * Description:
 */
class GithubRepoListAdapter(context: Context) : BaseAdapter<GitHubRepoVo>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<GitHubRepoVo> {
        val view = mInflater.inflate(R.layout.github_repo_list_item_layout, parent, false)
        return ViewHolder(view)
    }


    inner class ViewHolder(view: View) : BaseViewHolder<GitHubRepoVo>(view) {
        val name: TextView = itemView!!.findViewById(R.id.repo_name)
        val desc: TextView = itemView!!.findViewById(R.id.repo_desc)
        val star_count: TextView = itemView!!.findViewById(R.id.star_count)
        val fork_count: TextView = itemView!!.findViewById(R.id.fork_count)
        override fun onBind(i: GitHubRepoVo, p: Int) {
            super.onBind(i, p)
            name.text = if (i.name.length > 12) i.name.substring(0, 12) + "..." else i.name
            desc.text = if (i.description.isNullOrBlank()) "it's no description~!" else i.description
            fork_count.text = getShowText(i.forks_count)
            star_count.text = getShowText(i.stargazers_count)
            itemView?.setOnClickListener { WebActivity.startActivity(context, i.name, i.html_url) }
        }
    }

    fun getShowText(count: Int): String{
        var cs = count.toString()
        while (cs.length < 4) {
            cs += ' '
        }
        return cs
    }
}
