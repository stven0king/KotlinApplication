package com.dandan.tzx.main.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Tanzhenxing
 * Date: 2019-08-30 16:57
 * Description:
 */
data class GankDataEntityResults(
    @SerializedName("App")
    val app: List<GankItemEntiry>,
    @SerializedName("休息视频")
    val video: List<GankItemEntiry>,
    @SerializedName("福利")
    val meizhi: List<GankItemEntiry>,
    @SerializedName("拓展资源")
    val source: List<GankItemEntiry>,
    @SerializedName("前端")
    val fe: List<GankItemEntiry>,
    @SerializedName("瞎推荐")
    val recommend: List<GankItemEntiry>,
    @SerializedName("iOS")
    val ios: List<GankItemEntiry>,
    @SerializedName("Android")
    val android: List<GankItemEntiry>
)