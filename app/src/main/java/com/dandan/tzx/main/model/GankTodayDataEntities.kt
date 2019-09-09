package com.dandan.tzx.main.model

/**
 * Created by Tanzhenxing
 * Date: 2019-08-30 16:58
 * Description:
 */
data class GankTodayDataEntities(
    val category: List<String>,
    val error: Boolean,
    val results: GankDataEntityResults
)