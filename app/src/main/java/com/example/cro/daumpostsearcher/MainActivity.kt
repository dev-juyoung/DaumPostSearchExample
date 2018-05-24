package com.example.cro.daumpostsearcher

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebChromeClient
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val requestURL = "https://cdn.rawgit.com/dev-juyoung/bb4d52b1ad3bb0fd4a42e72cf2da00e3/raw/0312d6b7c0756af30514b7d2faa9f6703a535b07/eatcoin-post-searcher.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupWebView()
    }

    private fun setupWebView() {
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = PostSearcherClient(object : OnSearchResultListener {
            override fun onResult(info: JsonObject) {
                Log.d("SearcherResult", "info: $info")
            }
        })

        webView.settings.javaScriptEnabled = true
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.settings.setSupportMultipleWindows(true)

        webView.loadUrl(requestURL)
    }
}