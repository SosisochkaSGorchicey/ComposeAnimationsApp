package com.example.composeanimationsapp.screens.catGallery.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BoxScope.LoadingIndicator() {
    CircularProgressIndicator(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .align(Alignment.BottomCenter),
        strokeWidth = 3.dp
    )
}