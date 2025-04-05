package com.example.kidslaunchertv.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import com.example.kidslaunchertv.data.AppModel
import com.example.kidslaunchertv.utils.launchApp

@Composable
fun AppItem(app: AppModel) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .clickable { launchApp(app.packageName, context) }
            .focusable()
            .padding(8.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(app.icon),
            contentDescription = app.name,
            modifier = Modifier.fillMaxSize()
        )
    }
}