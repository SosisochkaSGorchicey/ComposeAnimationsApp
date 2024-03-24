package com.example.composeanimationsapp.components

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun BottomBar() {
    val selectedItem = rememberSaveable {
        mutableStateOf(BottomBarItem.CatGallery)
    }

    BottomAppBar(
        actions = {
            BottomBarItem.entries.forEach { bottomBarItem ->
                BottomNavigationItem(
                    selected = bottomBarItem == selectedItem.value,
                    onClick = {
                        selectedItem.value = bottomBarItem
                    },
                    icon = {
                        Icon(
                            painter = bottomBarItem.toIcon(),
                            contentDescription = null,
                            tint = if (bottomBarItem == selectedItem.value) MaterialTheme.colorScheme.onSurfaceVariant
                            else MaterialTheme.colorScheme.onSurface
                        )
                    },
                    label = {
                        Text(
                            text = bottomBarItem.toTitle()
                        )
                    },
                    selectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedContentColor = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    )
}