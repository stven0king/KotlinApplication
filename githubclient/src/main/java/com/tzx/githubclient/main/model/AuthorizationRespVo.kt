package com.tzx.githubclient.main.model

import android.os.Parcel
import android.os.Parcelable

data class AuthorizationRespVo(
    val app: App,
    val created_at: String,
    val fingerprint: String,
    val hashed_token: String,
    val id: Int,
    val note: String,
    val note_url: String,
    val scopes: List<String>,
    val token: String,
    val token_last_eight: String,
    val updated_at: String,
    val url: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readParcelable(App::class.java.classLoader),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.createStringArrayList(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    data class App(
            val client_id: String,
            val name: String,
            val url: String
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(client_id)
            parcel.writeString(name)
            parcel.writeString(url)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<App> {
            override fun createFromParcel(parcel: Parcel): App {
                return App(parcel)
            }

            override fun newArray(size: Int): Array<App?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(app, flags)
        parcel.writeString(created_at)
        parcel.writeString(fingerprint)
        parcel.writeString(hashed_token)
        parcel.writeInt(id)
        parcel.writeString(note)
        parcel.writeString(note_url)
        parcel.writeStringList(scopes)
        parcel.writeString(token)
        parcel.writeString(token_last_eight)
        parcel.writeString(updated_at)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AuthorizationRespVo> {
        override fun createFromParcel(parcel: Parcel): AuthorizationRespVo {
            return AuthorizationRespVo(parcel)
        }

        override fun newArray(size: Int): Array<AuthorizationRespVo?> {
            return arrayOfNulls(size)
        }
    }
}