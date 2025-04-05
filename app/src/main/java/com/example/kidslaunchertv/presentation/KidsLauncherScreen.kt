package com.example.kidslaunchertv.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kidslaunchertv.data.AppModel
import com.example.kidslaunchertv.utils.launchApp

@Composable
fun KidsLauncherScreen (apps: List<AppModel>) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2196F3)) // Blue background
            .padding(16.dp)
    ) {
        Text(
            text = "Kids Mode",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3), // 3-column layout
            modifier = Modifier.fillMaxSize()
        ) {
            items(apps.size) { index ->
                AppItem(apps[index])
            }
        }
    }
}

