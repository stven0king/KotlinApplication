package com.dandan.tzx.main.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Tanzhenxing
 * Date: 2019-08-30 16:58
 * Description:
 */
data class GankTodayDataEntities(
    val category: List<String>,
    val error: Boolean,
    val results: GankDataEntityResults
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.createStringArrayList(),
            parcel.readByte() != 0.toByte(),
            parcel.readParcelable(GankDataEntityResults::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringList(category)
        parcel.writeByte(if (error) 1 else 0)
        parcel.writeParcelable(results, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GankTodayDataEntities> {
        override fun createFromParcel(parcel: Parcel): GankTodayDataEntities {
            return GankTodayDataEntities(parcel)
        }

        override fun newArray(size: Int): Array<GankTodayDataEntities?> {
            return arrayOfNulls(size)
        }
    }
}