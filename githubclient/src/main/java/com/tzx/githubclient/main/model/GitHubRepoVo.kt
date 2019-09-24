package com.tzx.githubclient.main.model

import android.os.Parcel
import android.os.Parcelable

data class GitHubRepoVo(
    val archive_url: String,
    val archived: Boolean,
    val assignees_url: String,
    val blobs_url: String,
    val branches_url: String,
    val clone_url: String,
    val collaborators_url: String,
    val comments_url: String,
    val commits_url: String,
    val compare_url: String,
    val contents_url: String,
    val contributors_url: String,
    val created_at: String,
    val default_branch: String,
    val deployments_url: String,
    val description: String,
    val disabled: Boolean,
    val downloads_url: String,
    val events_url: String,
    val fork: Boolean,
    val forks: Int,
    val forks_count: Int,
    val forks_url: String,
    val full_name: String,
    val git_commits_url: String,
    val git_refs_url: String,
    val git_tags_url: String,
    val git_url: String,
    val has_downloads: Boolean,
    val has_issues: Boolean,
    val has_pages: Boolean,
    val has_projects: Boolean,
    val has_wiki: Boolean,
    val homepage: String?,
    val hooks_url: String,
    val html_url: String,
    val id: Int,
    val issue_comment_url: String,
    val issue_events_url: String,
    val issues_url: String,
    val keys_url: String,
    val labels_url: String,
    val language: String,
    val languages_url: String,
    val merges_url: String,
    val milestones_url: String,
    val mirror_url: String?,
    val name: String,
    val node_id: String,
    val notifications_url: String,
    val open_issues: Int,
    val open_issues_count: Int,
    val owner: Owner,
    val `private`: Boolean,
    val pulls_url: String,
    val pushed_at: String,
    val releases_url: String,
    val size: Int,
    val ssh_url: String,
    val stargazers_count: Int,
    val stargazers_url: String,
    val statuses_url: String,
    val subscribers_url: String,
    val subscription_url: String,
    val svn_url: String,
    val tags_url: String,
    val teams_url: String,
    val trees_url: String,
    val updated_at: String,
    val url: String,
    val watchers: Int,
    val watchers_count: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readParcelable(Owner::class.java.classLoader),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(archive_url)
        parcel.writeByte(if (archived) 1 else 0)
        parcel.writeString(assignees_url)
        parcel.writeString(blobs_url)
        parcel.writeString(branches_url)
        parcel.writeString(clone_url)
        parcel.writeString(collaborators_url)
        parcel.writeString(comments_url)
        parcel.writeString(commits_url)
        parcel.writeString(compare_url)
        parcel.writeString(contents_url)
        parcel.writeString(contributors_url)
        parcel.writeString(created_at)
        parcel.writeString(default_branch)
        parcel.writeString(deployments_url)
        parcel.writeString(description)
        parcel.writeByte(if (disabled) 1 else 0)
        parcel.writeString(downloads_url)
        parcel.writeString(events_url)
        parcel.writeByte(if (fork) 1 else 0)
        parcel.writeInt(forks)
        parcel.writeInt(forks_count)
        parcel.writeString(forks_url)
        parcel.writeString(full_name)
        parcel.writeString(git_commits_url)
        parcel.writeString(git_refs_url)
        parcel.writeString(git_tags_url)
        parcel.writeString(git_url)
        parcel.writeByte(if (has_downloads) 1 else 0)
        parcel.writeByte(if (has_issues) 1 else 0)
        parcel.writeByte(if (has_pages) 1 else 0)
        parcel.writeByte(if (has_projects) 1 else 0)
        parcel.writeByte(if (has_wiki) 1 else 0)
        parcel.writeString(homepage)
        parcel.writeString(hooks_url)
        parcel.writeString(html_url)
        parcel.writeInt(id)
        parcel.writeString(issue_comment_url)
        parcel.writeString(issue_events_url)
        parcel.writeString(issues_url)
        parcel.writeString(keys_url)
        parcel.writeString(labels_url)
        parcel.writeString(language)
        parcel.writeString(languages_url)
        parcel.writeString(merges_url)
        parcel.writeString(milestones_url)
        parcel.writeString(mirror_url)
        parcel.writeString(name)
        parcel.writeString(node_id)
        parcel.writeString(notifications_url)
        parcel.writeInt(open_issues)
        parcel.writeInt(open_issues_count)
        parcel.writeParcelable(owner, flags)
        parcel.writeByte(if (private) 1 else 0)
        parcel.writeString(pulls_url)
        parcel.writeString(pushed_at)
        parcel.writeString(releases_url)
        parcel.writeInt(size)
        parcel.writeString(ssh_url)
        parcel.writeInt(stargazers_count)
        parcel.writeString(stargazers_url)
        parcel.writeString(statuses_url)
        parcel.writeString(subscribers_url)
        parcel.writeString(subscription_url)
        parcel.writeString(svn_url)
        parcel.writeString(tags_url)
        parcel.writeString(teams_url)
        parcel.writeString(trees_url)
        parcel.writeString(updated_at)
        parcel.writeString(url)
        parcel.writeInt(watchers)
        parcel.writeInt(watchers_count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GitHubRepoVo> {
        override fun createFromParcel(parcel: Parcel): GitHubRepoVo {
            return GitHubRepoVo(parcel)
        }

        override fun newArray(size: Int): Array<GitHubRepoVo?> {
            return arrayOfNulls(size)
        }
    }

}


data class Owner(
        val avatar_url: String,
        val events_url: String,
        val followers_url: String,
        val following_url: String,
        val gists_url: String,
        val gravatar_id: String,
        val html_url: String,
        val id: Int,
        val login: String,
        val node_id: String,
        val organizations_url: String,
        val received_events_url: String,
        val repos_url: String,
        val site_admin: Boolean,
        val starred_url: String,
        val subscriptions_url: String,
        val type: String,
        val url: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(avatar_url)
        parcel.writeString(events_url)
        parcel.writeString(followers_url)
        parcel.writeString(following_url)
        parcel.writeString(gists_url)
        parcel.writeString(gravatar_id)
        parcel.writeString(html_url)
        parcel.writeInt(id)
        parcel.writeString(login)
        parcel.writeString(node_id)
        parcel.writeString(organizations_url)
        parcel.writeString(received_events_url)
        parcel.writeString(repos_url)
        parcel.writeByte(if (site_admin) 1 else 0)
        parcel.writeString(starred_url)
        parcel.writeString(subscriptions_url)
        parcel.writeString(type)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Owner> {
        override fun createFromParcel(parcel: Parcel): Owner {
            return Owner(parcel)
        }

        override fun newArray(size: Int): Array<Owner?> {
            return arrayOfNulls(size)
        }
    }
}