package com.example.composeanimationsapp.screens.catGallery.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.resources.R as CoreRes

@Composable
fun BoxScope.ErrorDisplay(retry: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .align(Alignment.BottomCenter),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = CoreRes.string.error_occurred),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Button(
            onClick = {
                retry()
            },
            shape = RoundedCornerShape(15),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Text(
                text = stringResource(id = CoreRes.string.button_retry),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}