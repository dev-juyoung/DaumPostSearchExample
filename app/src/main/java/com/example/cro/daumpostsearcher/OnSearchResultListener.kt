package com.example.cro.daumpostsearcher

import com.google.gson.JsonObject

interface OnSearchResultListener {
    fun onResult(info: JsonObject)
}