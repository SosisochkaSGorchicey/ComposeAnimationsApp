package com.example.composeanimationsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.example.composeanimationsapp.ui.theme.ComposeAnimationsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimationsAppTheme {
                Text(
                    text = ",lkmj",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}