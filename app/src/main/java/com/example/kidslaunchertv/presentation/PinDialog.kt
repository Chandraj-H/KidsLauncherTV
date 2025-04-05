package com.example.kidslaunchertv.presentation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun PinDialog(
    onPinEntered: (Boolean) -> Unit,
    onDismiss: () -> Unit
) {
    var pinInput by remember { mutableStateOf("") }
    val correctPin = "1234"

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = Color.White,
            tonalElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .width(IntrinsicSize.Min),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Enter PIN", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(12.dp))

                Row {
                    repeat(4) { index ->
                        val digit = pinInput.getOrNull(index)?.toString() ?: "-"
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color.LightGray, RoundedCornerShape(4.dp))
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = digit, style = MaterialTheme.typography.headlineMedium)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Number pad
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    val rows = listOf(
                        listOf("1", "2", "3"),
                        listOf("4", "5", "6"),
                        listOf("7", "8", "9"),
                        listOf("Del", "0", "OK")
                    )

                    rows.forEach { row ->
                        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                            row.forEach { label ->
                                Button(
                                    onClick = {
                                        when (label) {
                                            "Del" -> if (pinInput.isNotEmpty()) pinInput = pinInput.dropLast(1)
                                            "OK" -> {
                                                val isCorrect = pinInput == correctPin
                                                onPinEntered(isCorrect)
                                                pinInput = ""
                                            }
                                            else -> if (pinInput.length < 4) pinInput += label
                                        }
                                    },
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .size(64.dp),
                                ) {
                                    Text(label)
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = {
                    pinInput = ""
                    onDismiss()
                }) {
                    Text("Cancel")
                }
            }
        }
    }
}