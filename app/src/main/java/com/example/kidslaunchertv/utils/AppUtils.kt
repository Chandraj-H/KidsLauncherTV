package com.example.kidslaunchertv.utils

import android.content.Context
import android.content.Intent

fun launchApp(packageName: String, context: Context) {
    val intent = context.packageManager.getLaunchIntentForPackage(packageName)
    intent?.let {
        it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(it)
    }
}

val allowedApps = listOf(
    "com.google.android.youtube.tv",
    "com.netflix.ninja",
    "com.disney.disneyplus"
)

fun isAppAllowed(packageName: String): Boolean {
    return allowedApps.contains(packageName)
}
