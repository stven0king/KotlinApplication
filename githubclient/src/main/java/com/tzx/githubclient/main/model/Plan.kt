package com.tzx.githubclient.main.model

import android.os.Parcel
import android.os.Parcelable

data class Plan(
    val collaborators: Int,
    val name: String,
    val private_repos: Int,
    val space: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(collaborators)
        parcel.writeString(name)
        parcel.writeInt(private_repos)
        parcel.writeInt(space)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Plan> {
        override fun createFromParcel(parcel: Parcel): Plan {
            return Plan(parcel)
        }

        override fun newArray(size: Int): Array<Plan?> {
            return arrayOfNulls(size)
        }
    }
}