package com.example.cro.daumpostsearcher

import android.annotation.TargetApi
import android.os.Build
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.gson.JsonParser

class PostSearcherClient(val listener: OnSearchResultListener) : WebViewClient() {
    private val responsePrefix = "address://"

    @SuppressWarnings("deprecation")
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean = checkedUrl(url)

    @TargetApi(Build.VERSION_CODES.N)
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean = checkedUrl(request?.url.toString())

    private fun checkedUrl(url: String?): Boolean {
        if (url == null) return false

        if (url.startsWith(responsePrefix)) {
            val resultString = url.substring(responsePrefix.length).decode()
            val resultJson = JsonParser().parse(resultString).asJsonObject
            listener.onResult(resultJson)

            return true
        }

        return false
    }
}