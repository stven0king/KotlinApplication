package com.dandan.tzx.main.model

import android.os.Parcel
import android.os.Parcelable

data class GankItemEntiry(
    val _id: String,
    val createdAt: String,
    val desc: String,
    val images: List<String>?,
    val publishedAt: String,
    val source: String,
    val type: String,
    val url: String,
    val used: Boolean,
    val who: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createStringArrayList(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(createdAt)
        parcel.writeString(desc)
        parcel.writeStringList(images)
        parcel.writeString(publishedAt)
        parcel.writeString(source)
        parcel.writeString(type)
        parcel.writeString(url)
        parcel.writeByte(if (used) 1 else 0)
        parcel.writeString(who)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GankItemEntiry> {
        override fun createFromParcel(parcel: Parcel): GankItemEntiry {
            return GankItemEntiry(parcel)
        }

        override fun newArray(size: Int): Array<GankItemEntiry?> {
            return arrayOfNulls(size)
        }
    }
}