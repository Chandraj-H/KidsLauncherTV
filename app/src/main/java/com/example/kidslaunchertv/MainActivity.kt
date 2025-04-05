package com.example.kidslaunchertv

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.kidslaunchertv.data.getInstalledApps
import com.example.kidslaunchertv.presentation.KidsLauncherScreen
import com.example.kidslaunchertv.presentation.PinDialog
import com.example.kidslaunchertv.ui.theme.KidsLauncherTVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apps = getInstalledApps(this)
        setContent {
            KidsLauncherTVTheme {
                var showPinDialog by remember { mutableStateOf(false) }
                var pinSuccess by remember { mutableStateOf(false) }

                Box(modifier = Modifier.fillMaxSize()) {
                    KidsLauncherScreen(apps, onSettingsClick = {
                        showPinDialog = true
                    })

                    if (showPinDialog) {
                        PinDialog(
                            onPinEntered = { isCorrect ->
                                if (isCorrect) {
                                    pinSuccess = true
                                    println(pinSuccess)
                                    val intent = Intent(Intent.ACTION_MAIN).apply {
                                        addCategory(Intent.CATEGORY_HOME)
                                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                    }
                                    startActivity(intent)
                                } else {
                                    // Did not handle error yet
                                }
                                showPinDialog = false
                            },
                            onDismiss = { showPinDialog = false }
                        )
                    }
                }
            }
        }
    }
}

