package com.example.cro.daumpostsearcher.extention

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.customtabs.CustomTabsIntent

inline fun Context.isInstalledApp(packageName: String): Boolean = packageManager.getLaunchIntentForPackage(packageName) != null

inline fun Context.launchWeb(url: Uri) {
    if (!isInstalledApp("com.android.chrome")) {
        startActivity(Intent(Intent.ACTION_VIEW, url))
        return
    }

    CustomTabsIntent.Builder().apply {
        // options
    }.build().run {
        launchUrl(this@launchWeb, url)
    }
}