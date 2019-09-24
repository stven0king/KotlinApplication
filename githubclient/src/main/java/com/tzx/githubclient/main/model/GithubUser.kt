package com.tzx.githubclient.main.model

import android.os.Parcel
import android.os.Parcelable

data class GithubUser(
    val avatar_url: String,
    val bio: String,
    val blog: String,
    val collaborators: Int,
    val company: String,
    val created_at: String,
    val disk_usage: Int,
    val email: String,
    val events_url: String,
    val followers: Int,
    val followers_url: String,
    val following: Int,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val hireable: Any,
    val html_url: String,
    val id: Int,
    val location: String,
    val login: String,
    val name: String,
    val node_id: String,
    val organizations_url: String,
    val owned_private_repos: Int,
    val plan: Plan,
    val private_gists: Int,
    val public_gists: Int,
    val public_repos: Int,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val total_private_repos: Int,
    val two_factor_authentication: Boolean,
    val type: String,
    val updated_at: String,
    val url: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            TODO("hireable"),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readParcelable(Plan::class.java.classLoader),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(avatar_url)
        parcel.writeString(bio)
        parcel.writeString(blog)
        parcel.writeInt(collaborators)
        parcel.writeString(company)
        parcel.writeString(created_at)
        parcel.writeInt(disk_usage)
        parcel.writeString(email)
        parcel.writeString(events_url)
        parcel.writeInt(followers)
        parcel.writeString(followers_url)
        parcel.writeInt(following)
        parcel.writeString(following_url)
        parcel.writeString(gists_url)
        parcel.writeString(gravatar_id)
        parcel.writeString(html_url)
        parcel.writeInt(id)
        parcel.writeString(location)
        parcel.writeString(login)
        parcel.writeString(name)
        parcel.writeString(node_id)
        parcel.writeString(organizations_url)
        parcel.writeInt(owned_private_repos)
        parcel.writeParcelable(plan, flags)
        parcel.writeInt(private_gists)
        parcel.writeInt(public_gists)
        parcel.writeInt(public_repos)
        parcel.writeString(received_events_url)
        parcel.writeString(repos_url)
        parcel.writeByte(if (site_admin) 1 else 0)
        parcel.writeString(starred_url)
        parcel.writeString(subscriptions_url)
        parcel.writeInt(total_private_repos)
        parcel.writeByte(if (two_factor_authentication) 1 else 0)
        parcel.writeString(type)
        parcel.writeString(updated_at)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GithubUser> {
        override fun createFromParcel(parcel: Parcel): GithubUser {
            return GithubUser(parcel)
        }

        override fun newArray(size: Int): Array<GithubUser?> {
            return arrayOfNulls(size)
        }
    }
}