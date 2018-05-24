package com.example.cro.daumpostsearcher

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebChromeClient
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val requestURL = "https://goo.gl/ff7hco"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupWebView()
    }

    private fun setupWebView() {
        webView.run {
            settings.javaScriptEnabled = true
            settings.javaScriptCanOpenWindowsAutomatically = true
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
            settings.setSupportMultipleWindows(true)

            webChromeClient = WebChromeClient()
            webViewClient = PostSearcherClient(object : OnSearchResultListener {
                override fun onResult(info: JsonObject) {
                    Log.d("SearcherResult", "info: $info")
                }
            })

            loadUrl(requestURL)
        }
    }
}