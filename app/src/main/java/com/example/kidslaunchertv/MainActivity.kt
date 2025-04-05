package com.example.kidslaunchertv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.example.kidslaunchertv.data.getInstalledApps
import com.example.kidslaunchertv.presentation.KidsLauncherScreen
import com.example.kidslaunchertv.ui.theme.KidsLauncherTVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apps = getInstalledApps(this)
        setContent {
            KidsLauncherTVTheme {
                KidsLauncherScreen(apps)
            }
        }
    }
}

