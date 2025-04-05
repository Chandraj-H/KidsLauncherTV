package com.example.kidslaunchertv.data

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import com.example.kidslaunchertv.utils.isAppAllowed

fun getInstalledApps(context: Context): List<AppModel> {
    val pm = context.packageManager

    val intent = Intent(Intent.ACTION_MAIN, null).apply {
        addCategory(Intent.CATEGORY_LAUNCHER)
    }
    val apps = pm.queryIntentActivities(intent, 0).map { app ->
        val appInfo = app.activityInfo.applicationInfo
        AppModel(
            name = app.loadLabel(pm).toString(),
            packageName = appInfo.packageName,
            icon = appInfo.loadIcon(pm)
        )
    }

    return apps.filter { isAppAllowed(it.packageName) }
}