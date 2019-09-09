package com.dandan.tzx.main.model

public var historyList:GankHistoryDay? = null

data class GankHistoryDay(
    val error: Boolean,
    val results: List<String>
)